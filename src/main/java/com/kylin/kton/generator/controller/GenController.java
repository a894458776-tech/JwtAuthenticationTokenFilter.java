package com.kylin.kton.generator.controller;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.generator.domain.GenTable;
import com.kylin.kton.generator.domain.GenTableColumn;
import com.kylin.kton.generator.service.IGenTableColumnService;
import com.kylin.kton.generator.service.IGenTableService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tool/gen")
public class GenController extends BaseController {
    @Autowired
    private IGenTableService genTableService;

    @Autowired
    private IGenTableColumnService genTableColumnService;

    @PreAuthorize("@ss.hasPermi('tool:gen:list')")
    @GetMapping("/list")
    public TableDataInfo list(GenTable genTable) {
        startPage();
        List<GenTable> list = genTableService.selectGenTableList(genTable);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:query')")
    @GetMapping(value = "/{tableId}")
    public AjaxResult getInfo(@PathVariable Long tableId) {
        GenTable table = genTableService.selectGenTableById(tableId);
        List<GenTable> tables = genTableService.selectGenTableAll();
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(tableId);
        Map<String, Object> map = new java.util.HashMap<>();
        map.put("info", table);
        map.put("rows", list);
        map.put("tables", tables);
        return success(map);
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:list')")
    @GetMapping("/db/list")
    public TableDataInfo dataList(GenTable genTable) {
        startPage();
        List<GenTable> list = genTableService.selectDbTableList(genTable);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:list')")
    @GetMapping(value = "/column/{tableId}")
    public TableDataInfo columnList(Long tableId) {
        TableDataInfo dataInfo = new TableDataInfo();
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(tableId);
        dataInfo.setRows(list);
        dataInfo.setTotal(list.size());
        return dataInfo;
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:import')")
    @PostMapping("/importTable")
    public AjaxResult importTableSave(String tables) {
        String[] tableNames = tables.split(",");
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        // 【修复】增加 getUsername() 参数
        genTableService.importGenTable(tableList, getUsername());
        return success();
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody GenTable genTable) {
        genTableService.validateEdit(genTable);
        genTableService.updateGenTable(genTable);
        return success();
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:remove')")
    @DeleteMapping("/{tableIds}")
    public AjaxResult remove(@PathVariable Long[] tableIds) {
        genTableService.deleteGenTableByIds(tableIds);
        return success();
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:preview')")
    @GetMapping("/preview/{tableId}")
    public AjaxResult preview(@PathVariable("tableId") Long tableId) throws IOException {
        Map<String, String> dataMap = genTableService.previewCode(tableId);
        return success(dataMap);
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:code')")
    @GetMapping("/download/{tableName}")
    public void download(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException {
        byte[] data = genTableService.downloadCode(tableName);
        genCode(response, data);
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:code')")
    @GetMapping("/genCode/{tableName}")
    public AjaxResult genCode(@PathVariable("tableName") String tableName) {
        genTableService.generatorCode(tableName);
        return success();
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:code')")
    @GetMapping("/synchDb/{tableName}")
    public AjaxResult synchDb(@PathVariable("tableName") String tableName) {
        genTableService.synchDb(tableName);
        return success();
    }

    @PreAuthorize("@ss.hasPermi('tool:gen:code')")
    @GetMapping("/batchGenCode")
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException {
        String[] tableNames = tables.split(",");
        byte[] data = genTableService.downloadCode(tableNames);
        genCode(response, data);
    }

    @PostMapping("/createTable")
    public AjaxResult createTable(String sql) {
        try {
            List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, "mysql");
            List<String> tableNames = new ArrayList<>();
            for (SQLStatement sqlStatement : sqlStatements) {
                if (sqlStatement instanceof MySqlCreateTableStatement) {
                    MySqlCreateTableStatement createTableStatement = (MySqlCreateTableStatement) sqlStatement;
                    if (genTableService.createTable(createTableStatement.toString())) {
                        String tableName = createTableStatement.getTableSource().getName().getSimpleName();
                        tableNames.add(tableName.replaceAll("`", ""));
                    }
                }
            }
            List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames.toArray(new String[0]));
            // 【修复】增加 getUsername() 参数
            genTableService.importGenTable(tableList, getUsername());
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error("创建表结构异常");
        }
    }

    private void genCode(HttpServletResponse response, byte[] data) throws IOException {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"ruoyi.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}