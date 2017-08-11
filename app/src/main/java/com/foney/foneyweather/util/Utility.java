package com.foney.foneyweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.foney.foneyweather.db.City;
import com.foney.foneyweather.db.County;
import com.foney.foneyweather.db.Province;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by foney on 2017/8/11.
 */

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if(!TextUtils.isEmpty(response)) {
            try{
                JSONArray provinces = new JSONArray(response);
                for(int i = 0;i < provinces.length();i++) {
                    JSONObject proviceJSONObject = provinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(proviceJSONObject.getString("provinceName"));
                    province.setProvinceCode(proviceJSONObject.getString("provinceCode"));
                    province.save();
                }
                return true;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     *
     * @param response
     * 解析和处理服务返回的城市数据
     */
    public static boolean handleCityResponse(String response) {
        if(!TextUtils.isEmpty(response)) {
            try{
                JSONArray citys = new JSONArray(response);
                for (int i = 0; i < citys.length(); i++) {
                    JSONObject cityJSONObject = citys.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityJSONObject.getString("cityName"));
                    city.setCityCode(cityJSONObject.getString("cityCode"));
                    city.setProvinceId(cityJSONObject.getInt("provinceId"));
                    city.save();
                }
                return true;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String response) {
        if(!TextUtils.isEmpty(response)) {
            try{
                JSONArray countys = new JSONArray(response);
                for (int i = 0; i < countys.length(); i++) {
                    JSONObject countyJSONObject = countys.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyJSONObject.getString("countyName"));
                    county.setCountyCode(countyJSONObject.getString("countyCode"));
                    county.setCityId(countyJSONObject.getInt("cityId"));
                    county.save();
                    return true;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
