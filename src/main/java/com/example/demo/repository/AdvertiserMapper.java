package com.example.demo.repository;

import com.example.demo.model.Advertiser;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdvertiserMapper {

  @Select("select * from advertisers")
  public List<Advertiser> findAll();

  @Select("SELECT * FROM advertisers WHERE id = #{id}")
  public Advertiser findById(int id);

  @Delete("DELETE FROM advertisers WHERE id = #{id}")
  public int deleteById(int id);

  @Insert("INSERT INTO advertisers(advertiserName, advertiserContactName, creditLimit) VALUES (#{advertiserName}, #{advertiserContactName}, #{creditLimit})")
  public int insert(Advertiser advertiser);

  @Update("Update advertisers set advertiserName=#{advertiserName}, advertiserContactName=#{advertiserContactName}, creditLimit=#{creditLimit} where advertiserName=#{advertiserName}")
  public int update(Advertiser advertiser);

}
