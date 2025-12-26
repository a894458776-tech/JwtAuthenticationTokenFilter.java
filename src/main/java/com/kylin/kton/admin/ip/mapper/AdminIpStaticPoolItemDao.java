/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
 *  com.kylin.kton.system.domain.KtonMerchant
 *  javax.annotation.Nullable
 *  org.apache.ibatis.annotations.Delete
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Many
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Result
 *  org.apache.ibatis.annotations.Results
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolItemDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolItemInfoDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminPoolIpCount;
import com.kylin.kton.admin.ip.entity.dto.AdminUnassignedIpsDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticPoolAllListSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticPoolListSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminUnassignedIpsVO;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import com.kylin.kton.system.domain.KtonMerchant;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminIpStaticPoolItemDao {
    @Insert(value={"<script>INSERT INTO kton_ip_static_pool_item (pool_id, ip, status, create_time, update_time) VALUES <foreach collection='list' item='item' separator=','>   (#{item.poolId}, #{item.ip}, #{item.status}, #{item.createTime}, #{item.updateTime})</foreach></script>"})
    public int batchInsertIpPoolItems(@Param(value="list") List<KtonIpStaticPoolItem> var1);

    @Update(value={"<script> UPDATE kton_ip_static_pool_item  SET status =  #{status} ,     update_time = NOW() WHERE pool_id = #{poolId} and ip = #{ip} </script>"})
    public int updateByPoolIdAndIp(@Param(value="poolId") Long var1, @Param(value="ip") String var2, @Param(value="status") Integer var3);

    @Select(value={"<script> SELECT *,a.id as item_id   FROM kton_ip_static_pool_item  AS a  LEFT JOIN kton_ip_static_source AS b ON a.ip  = b.ip  LEFT JOIN kton_source AS c ON b.source_id  = c.id  WHERE 1 = 1  <when test='vo.poolId!=null'>  AND a.pool_id =   #{vo.poolId} </when> <when test='vo.ip!=null'>  AND a.ip like concat('%', #{vo.ip}, '%') </when> <when test='vo.port!=null'> AND a.port = #{vo.port} </when> <when test='vo.itemStatus!=null'> AND a.status = #{vo.itemStatus} </when> ORDER BY a.id DESC</script>"})
    public List<AdminIpStaticPoolItemInfoDTO> list(@Param(value="vo") AdminIpStaticPoolListSearchVO var1);

    @Select(value={"<script> SELECT a.ip,a.id as item_id,GROUP_CONCAT(DISTINCT a.merchant_id) AS merchant_ids,b.*,c.port,c.account,c.password,c.protocolse,c.effective_datetime,c.expire_datetime,c.assign_times,c.status as item_status   FROM kton_ip_static_pool_item  AS a  LEFT JOIN kton_ip_static_pool AS b ON a.pool_id  = b.id  LEFT JOIN kton_ip_static_source AS c ON a.ip  = c.ip  LEFT JOIN kton_source AS d ON c.source_id  = d.id  WHERE 1 = 1  <when test='vo.type!=null'> AND b.type = #{vo.type} </when> <when test='vo.continent!=null'> AND b.continent = #{vo.continent} </when> <when test='vo.countryCode!=null'> AND b.country_code = #{vo.countryCode} </when> <when test='vo.location!=null'> AND b.location = #{vo.location} </when> <when test='vo.ip!=null'> AND a.ip = #{vo.ip} </when> <when test='vo.port!=null'> AND a.port = #{vo.port} </when> <when test='vo.merchantId!=null'> AND a.merchant_id = #{vo.merchantId} </when> <when test='vo.itemStatus!=null'> AND a.status = #{vo.itemStatus} </when> GROUP BY a.ip  ORDER BY a.id DESC</script>"})
    @Results(value={@Result(column="merchant_id", property="merchantId"), @Result(column="source_id", property="sourceId"), @Result(column="merchant_ids", property="merchant", javaType=List.class, many=@Many(select="selectMerchantInfoByIds"))})
    public List<AdminIpStaticPoolItemDTO> allList(@Param(value="vo") AdminIpStaticPoolAllListSearchVO var1);

    @Select(value={"SELECT * FROM kton_merchant WHERE id IN (${ids})"})
    public List<KtonMerchant> selectMerchantInfoByIds(@Param(value="ids") String var1);

    @Update(value={"CREATE TEMPORARY TABLE temp_ip_data (pool_id BIGINT, ip VARCHAR(15))"})
    public int createTempTable();

    @Select(value={"<script>", "SELECT c.id AS poolId, COUNT(b.ip) AS ipCount ", "FROM kton_ip_static_source a ", "JOIN kton_ip_detect b ON a.ip = b.ip ", "   AND a.assign_times &lt;= #{assignTimes} ", "   AND a.expire_datetime &gt; NOW() ", "   AND a.status != 2 ", "   <if test='specifyIpSwitch == 1 and ipList != null and !ipList.isEmpty()'>", "       AND (", "           <foreach item='ipPattern' collection='ipList' separator=' OR '>", "               a.ip LIKE #{ipPattern} ", "           </foreach>", "       ) ", "   </if>", "   <if test='specifyIpSwitch == 2 and ipList != null and !ipList.isEmpty()'>", "       AND (", "           <foreach item='ip' collection='ipList' separator=' OR '>", "               a.ip = #{ip} ", "           </foreach>", "       ) ", "   </if>", "JOIN kton_ip_static_pool c ON ", "   b.country_code = c.country_code ", "   AND b.province = c.location ", "   AND b.is_native = c.type ", "LEFT JOIN kton_ip_static_pool_item d ON c.id = d.pool_id AND b.ip = d.ip AND d.merchant_id IN ", "       <foreach collection='merchantIds' item='merchantId' open='(' separator=',' close=')'>", "           #{merchantId}", "       </foreach>", "LEFT JOIN kton_ip_static_merchant m ON b.ip = m.ip AND m.merchant_id IN ", "       <foreach collection='merchantIds' item='merchantId' open='(' separator=',' close=')'>", "           #{merchantId}", "       </foreach>", "WHERE 1 = 1 ", "   AND d.ip IS NULL ", "   AND m.ip IS NULL ", "<if test='poolId != null'>", "   AND c.id = #{poolId} ", "</if>", "GROUP BY c.id", "</script>"})
    public List<AdminPoolIpCount> checkAvailableIpCount(@Param(value="poolId") @Nullable Long var1, @Param(value="specifyIpSwitch") @Nullable Integer var2, @Param(value="ipList") @Nullable List<String> var3, @Param(value="merchantIds") @Nullable List<Long> var4, @Param(value="assignTimes") Integer var5);

    @Update(value={"<script>", "INSERT INTO temp_ip_data (pool_id, ip) ", "SELECT id, ip FROM (", "   SELECT c.id, b.ip, ", "       ROW_NUMBER() OVER (PARTITION BY c.id ORDER BY a.expire_datetime DESC, a.assign_times DESC, b.ip DESC ) as rn ", "   FROM kton_ip_static_source a ", "   JOIN kton_ip_detect b ON a.ip = b.ip ", "       AND a.assign_times &lt;= #{assignTimes} ", "       AND a.expire_datetime &gt; NOW() ", "       AND a.status != 2 ", "       <if test='specifyIpSwitch == 1 and ipList != null and !ipList.isEmpty()'>", "           AND (", "               <foreach item='ipPattern' collection='ipList' separator=' OR '>", "                   a.ip LIKE #{ipPattern} ", "               </foreach>", "           ) ", "       </if>", "       <if test='specifyIpSwitch == 2 and ipList != null and !ipList.isEmpty()'>", "           AND (", "               <foreach item='ip' collection='ipList' separator=' OR '>", "                   a.ip = #{ip} ", "               </foreach>", "           ) ", "       </if>", "   JOIN kton_ip_static_pool c ON ", "       b.country_code = c.country_code ", "       AND b.province = c.location ", "       AND b.is_native = c.type ", "   LEFT JOIN kton_ip_static_pool_item d ON c.id = d.pool_id AND b.ip = d.ip AND d.merchant_id IN ", "       <foreach collection='merchantIds' item='merchantId' open='(' separator=',' close=')'>", "           #{merchantId}", "       </foreach>", "   LEFT JOIN kton_ip_static_merchant m ON b.ip = m.ip AND m.merchant_id IN ", "       <foreach collection='merchantIds' item='merchantId' open='(' separator=',' close=')'>", "           #{merchantId}", "       </foreach>", "   WHERE 1 = 1 ", "   AND d.ip IS NULL ", "   AND m.ip IS NULL ", "   <if test='poolId != null'>", "       AND c.id = #{poolId} ", "   </if>", ") t ", "WHERE rn &lt;= #{quantity} ", "</script>"})
    public int insertIntoTempTable(@Param(value="poolId") @Nullable Long var1, @Param(value="quantity") @Nullable Integer var2, @Param(value="specifyIpSwitch") @Nullable Integer var3, @Param(value="ipList") @Nullable List<String> var4, @Param(value="merchantIds") @Nullable List<Long> var5, @Param(value="assignTimes") Integer var6);

    @Update(value={"INSERT INTO kton_ip_static_pool_item (pool_id, ip, merchant_id) ", "SELECT t.pool_id, t.ip, #{merchantId} ", "FROM temp_ip_data t ", "ON DUPLICATE KEY UPDATE ip = VALUES(ip)"})
    public int insertSingleMerchant(@Param(value="merchantId") Long var1);

    @Update(value={"DROP TEMPORARY TABLE temp_ip_data"})
    public int dropTempTable();

    @Select(value={"SELECT count(*)     FROM kton_ip_static_pool_item     WHERE merchant_id = #{merchantId}  "})
    public Integer checkIsExists(@Param(value="merchantId") Long var1, @Param(value="ip") String var2);

    @Delete(value={"<script>", "DELETE FROM kton_ip_static_pool_item ", "WHERE merchant_id = #{merchantId} ", "AND pool_id = #{poolId} ", "<if test='specifyIpSwitch == 1 and ipList != null and !ipList.isEmpty()'>", "   AND (", "       <foreach item='ipPattern' collection='ipList' separator=' OR '>", "           ip LIKE #{ipPattern} ", "       </foreach>", "   ) ", "</if>", "<if test='specifyIpSwitch == 2 and ipList != null and !ipList.isEmpty()'>", "   AND (", "       <foreach item='ip' collection='ipList' separator=' OR '>", "           ip = #{ip} ", "       </foreach>", "   ) ", "</if>", "</script>"})
    public int deleteIpByCondition(@Param(value="merchantId") @Nullable Long var1, @Param(value="poolId") @Nullable Long var2, @Param(value="specifyIpSwitch") @Nullable Integer var3, @Param(value="ipList") @Nullable List<String> var4);

    @Select(value={"<script>", "SELECT b.province, a.* ", "FROM kton_ip_static_source a", "LEFT JOIN kton_ip_detect b ON a.ip = b.ip", "WHERE 1 = 1 ", "  AND b.country_code = #{vo.countryCode}", "  AND b.is_native = #{vo.isNative}", "  AND a.expire_datetime > NOW()", "  <if test=\"vo.merchantId != null\">", "    AND NOT EXISTS (", "      SELECT 1", "      FROM kton_ip_static_pool_item c", "      WHERE c.ip = a.ip", "        AND c.merchant_id = #{vo.merchantId}", "    )", "  </if>", "</script>"})
    public List<AdminUnassignedIpsDTO> unassignedIps(@Param(value="vo") AdminUnassignedIpsVO var1);
}

