package com.kevinwong.sgpsi.data.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.kevinwong.sgpsi.model.ApiInfo;
import com.kevinwong.sgpsi.model.LabelLocation;
import com.kevinwong.sgpsi.model.PSIResponse;
import com.kevinwong.sgpsi.model.RegionMetadatum;

import java.lang.reflect.Type;
import java.util.ArrayList;



public class PSIDeserializer implements JsonDeserializer<PSIResponse> {
    @Override
    public PSIResponse deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException {


        PSIResponse psiResponse = new PSIResponse();
        if (je.isJsonObject()) {
            /**
             * Parse API INFO
             */
            JsonObject jsonObject = je.getAsJsonObject().getAsJsonObject("api_info");
            ApiInfo apiInfo = new ApiInfo();
            apiInfo.setStatus(jsonObject.get("status").getAsString());
            psiResponse.setApiInfo(apiInfo);


            /**
             * Parse REGION DATA
             */

            JsonArray jsonRegionElements = je.getAsJsonObject().getAsJsonArray("region_metadata");

            if (jsonRegionElements != null && jsonRegionElements.size() > 0) {
                ArrayList<RegionMetadatum> regionMetadataList = new ArrayList<>();
                psiResponse.setRegionMetadata(regionMetadataList);
                for (int i = 0; i < jsonRegionElements.size(); i++) {
                    RegionMetadatum regionMetadatum = new RegionMetadatum();
                    JsonObject jsonRegion = jsonRegionElements.get(i).getAsJsonObject();
                    regionMetadatum.setName(jsonRegion.get("name").getAsString());
                    LabelLocation labelLocation = new LabelLocation();
                    labelLocation.setLatitude(jsonRegion.getAsJsonObject("label_location").get("latitude").getAsFloat());
                    labelLocation.setLongitude(jsonRegion.getAsJsonObject("label_location").get("longitude").getAsFloat());
                    regionMetadatum.setLabelLocation(labelLocation);
                    regionMetadataList.add(regionMetadatum);
                }
            }

            /**
             * Parse Other Datas
             */

            if (psiResponse.getRegionMetadata() != null && psiResponse.getRegionMetadata().size() > 0) {
                JsonArray itemArray = je.getAsJsonObject().get("items").getAsJsonArray();
                JsonObject itemJson = itemArray.get(0).getAsJsonObject();
                JsonObject readingJson = itemJson.get("readings").getAsJsonObject();
                if (readingJson.get("o3_sub_index").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setO3_sub_index(readingJson.get("o3_sub_index").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("pm10_twenty_four_hourly").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setPm10_twenty_four_hourly(readingJson.get("pm10_twenty_four_hourly").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("pm10_sub_index").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setPm10_sub_index(readingJson.get("pm10_sub_index").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("co_sub_index").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setCo_sub_index(readingJson.get("co_sub_index").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("pm25_twenty_four_hourly").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setPm25_twenty_four_hourly(readingJson.get("pm25_twenty_four_hourly").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("so2_sub_index").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setSo2_sub_index(readingJson.get("so2_sub_index").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("co_eight_hour_max").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setCo_eight_hour_max(readingJson.get("co_eight_hour_max").getAsJsonObject().get(regionMetadatum.getName()).getAsFloat());
                    }
                }

                if (readingJson.get("no2_one_hour_max").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setNo2_one_hour_max(readingJson.get("no2_one_hour_max").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("so2_twenty_four_hourly").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setSo2_twenty_four_hourly(readingJson.get("so2_twenty_four_hourly").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("no2_one_hour_max").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setNo2_one_hour_max(readingJson.get("no2_one_hour_max").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("pm25_sub_index").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setPm25_sub_index(readingJson.get("pm25_sub_index").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("psi_twenty_four_hourly").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setPsi_twenty_four_hourly(readingJson.get("psi_twenty_four_hourly").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }

                if (readingJson.get("o3_eight_hour_max").getAsJsonObject() != null) {
                    for (RegionMetadatum regionMetadatum : psiResponse.getRegionMetadata()) {
                        regionMetadatum.setO3_eight_hour_max(readingJson.get("o3_eight_hour_max").getAsJsonObject().get(regionMetadatum.getName()).getAsInt());
                    }
                }


            }

        }
        //        ApiInfo apiInfo = new ApiInfo();
//        apiInfo.setStatus("OK");
//        psiResponse.setApiInfo(apiInfo);
        // Get the "content" element from the parsed JSON
//        List<NewsEntity> newsItemList = new ArrayList<>();
//
//        if (je.getAsJsonObject().get("results").isJsonArray()) {
//            JsonArray results = je.getAsJsonObject().getAsJsonArray("results");
//            for (int i = 0; i < results.size(); i++) {
//                JsonObject newsObject = results.get(i).getAsJsonObject();
//                String title = newsObject.get("title").getAsString();
//                String summary = newsObject.get("abstract").getAsString();
//                String url = newsObject.get("url").getAsString();
//                List<MediaEntity> mediaEntityList = new ArrayList<>();
//                if (newsObject.get("multimedia").isJsonArray()) {
//                    JsonArray multimedia = newsObject.getAsJsonArray("multimedia");
//                    for (int j = 0; j < multimedia.size(); j++) {
//                        MediaEntity mediaEntity = new MediaEntity(multimedia.get(j).getAsJsonObject().get("url").getAsString());
//                        mediaEntityList.add(mediaEntity);
//                    }
//                }
//                NewsEntity newsEntity = new NewsEntity(title, summary, url, mediaEntityList);
//                if (title != null) {
//                    newsItemList.add(newsEntity);
//                }
//            }
//        }
        return psiResponse;
    }
}
