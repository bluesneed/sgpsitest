package com.kevinwong.sgpsi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kevinwong.sgpsi.data.network.PSIDeserializer;
import com.kevinwong.sgpsi.model.PSIResponse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by JiawenHuang on 16/4/18.
 */
public class PSIUnitTest {


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testPSIDeserializer() {
        Gson gson = new GsonBuilder().registerTypeAdapter(PSIResponse.class, new PSIDeserializer())
                .create();
        String json = "{\n" +
                "    \"region_metadata\": [\n" +
                "        {\n" +
                "            \"name\": \"west\",\n" +
                "            \"label_location\": {\n" +
                "                \"latitude\": 1.35735,\n" +
                "                \"longitude\": 103.7\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"national\",\n" +
                "            \"label_location\": {\n" +
                "                \"latitude\": 0,\n" +
                "                \"longitude\": 0\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"east\",\n" +
                "            \"label_location\": {\n" +
                "                \"latitude\": 1.35735,\n" +
                "                \"longitude\": 103.94\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"central\",\n" +
                "            \"label_location\": {\n" +
                "                \"latitude\": 1.35735,\n" +
                "                \"longitude\": 103.82\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"south\",\n" +
                "            \"label_location\": {\n" +
                "                \"latitude\": 1.29587,\n" +
                "                \"longitude\": 103.82\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"north\",\n" +
                "            \"label_location\": {\n" +
                "                \"latitude\": 1.41803,\n" +
                "                \"longitude\": 103.82\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"timestamp\": \"2018-04-29T14:00:00+08:00\",\n" +
                "            \"update_timestamp\": \"2018-04-29T14:06:18+08:00\",\n" +
                "            \"readings\": {\n" +
                "                \"o3_sub_index\": {\n" +
                "                    \"west\": 22,\n" +
                "                    \"national\": 22,\n" +
                "                    \"east\": 15,\n" +
                "                    \"central\": 11,\n" +
                "                    \"south\": 18,\n" +
                "                    \"north\": 16\n" +
                "                },\n" +
                "                \"pm10_twenty_four_hourly\": {\n" +
                "                    \"west\": 35,\n" +
                "                    \"national\": 36,\n" +
                "                    \"east\": 25,\n" +
                "                    \"central\": 36,\n" +
                "                    \"south\": 28,\n" +
                "                    \"north\": 34\n" +
                "                },\n" +
                "                \"pm10_sub_index\": {\n" +
                "                    \"west\": 35,\n" +
                "                    \"national\": 36,\n" +
                "                    \"east\": 25,\n" +
                "                    \"central\": 36,\n" +
                "                    \"south\": 28,\n" +
                "                    \"north\": 34\n" +
                "                },\n" +
                "                \"co_sub_index\": {\n" +
                "                    \"west\": 9,\n" +
                "                    \"national\": 9,\n" +
                "                    \"east\": 3,\n" +
                "                    \"central\": 6,\n" +
                "                    \"south\": 5,\n" +
                "                    \"north\": 7\n" +
                "                },\n" +
                "                \"pm25_twenty_four_hourly\": {\n" +
                "                    \"west\": 19,\n" +
                "                    \"national\": 21,\n" +
                "                    \"east\": 12,\n" +
                "                    \"central\": 17,\n" +
                "                    \"south\": 14,\n" +
                "                    \"north\": 21\n" +
                "                },\n" +
                "                \"so2_sub_index\": {\n" +
                "                    \"west\": 26,\n" +
                "                    \"national\": 26,\n" +
                "                    \"east\": 2,\n" +
                "                    \"central\": 3,\n" +
                "                    \"south\": 6,\n" +
                "                    \"north\": 5\n" +
                "                },\n" +
                "                \"co_eight_hour_max\": {\n" +
                "                    \"west\": 0.85,\n" +
                "                    \"national\": 0.85,\n" +
                "                    \"east\": 0.29,\n" +
                "                    \"central\": 0.58,\n" +
                "                    \"south\": 0.53,\n" +
                "                    \"north\": 0.73\n" +
                "                },\n" +
                "                \"no2_one_hour_max\": {\n" +
                "                    \"west\": 18,\n" +
                "                    \"national\": 20,\n" +
                "                    \"east\": 11,\n" +
                "                    \"central\": 20,\n" +
                "                    \"south\": 20,\n" +
                "                    \"north\": 11\n" +
                "                },\n" +
                "                \"so2_twenty_four_hourly\": {\n" +
                "                    \"west\": 42,\n" +
                "                    \"national\": 42,\n" +
                "                    \"east\": 3,\n" +
                "                    \"central\": 5,\n" +
                "                    \"south\": 10,\n" +
                "                    \"north\": 8\n" +
                "                },\n" +
                "                \"pm25_sub_index\": {\n" +
                "                    \"west\": 59,\n" +
                "                    \"national\": 62,\n" +
                "                    \"east\": 51,\n" +
                "                    \"central\": 56,\n" +
                "                    \"south\": 53,\n" +
                "                    \"north\": 62\n" +
                "                },\n" +
                "                \"psi_twenty_four_hourly\": {\n" +
                "                    \"west\": 59,\n" +
                "                    \"national\": 62,\n" +
                "                    \"east\": 51,\n" +
                "                    \"central\": 56,\n" +
                "                    \"south\": 53,\n" +
                "                    \"north\": 62\n" +
                "                },\n" +
                "                \"o3_eight_hour_max\": {\n" +
                "                    \"west\": 52,\n" +
                "                    \"national\": 52,\n" +
                "                    \"east\": 34,\n" +
                "                    \"central\": 25,\n" +
                "                    \"south\": 42,\n" +
                "                    \"north\": 37\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"api_info\": {\n" +
                "        \"status\": \"healthy\"\n" +
                "    }\n" +
                "}";


        PSIResponse psiResponse = gson.fromJson(json, PSIResponse.class);
        assertEquals("healthy", psiResponse.getApiInfo().getStatus());
        assertEquals("west", psiResponse.getRegionMetadata().get(0).getName());
        assertEquals(1.35735, psiResponse.getRegionMetadata().get(0).getLabelLocation().getLatitude(), 1);
        assertEquals(103.7, psiResponse.getRegionMetadata().get(0).getLabelLocation().getLongitude(), 1);

        assertEquals(22, psiResponse.getRegionMetadata().get(0).getO3_sub_index());

        assertEquals(35, psiResponse.getRegionMetadata().get(0).getPm10_twenty_four_hourly());

        assertEquals(35, psiResponse.getRegionMetadata().get(0).getPm10_sub_index());

        assertEquals(9, psiResponse.getRegionMetadata().get(0).getCo_sub_index());

        assertEquals(19, psiResponse.getRegionMetadata().get(0).getPm25_twenty_four_hourly());

        assertEquals(26, psiResponse.getRegionMetadata().get(0).getSo2_sub_index());

        assertEquals(0.85, psiResponse.getRegionMetadata().get(0).getCo_eight_hour_max(),1);

        assertEquals(59, psiResponse.getRegionMetadata().get(0).getPm25_sub_index());

        assertEquals(59, psiResponse.getRegionMetadata().get(0).getPsi_twenty_four_hourly());

        assertEquals(52, psiResponse.getRegionMetadata().get(0).getO3_eight_hour_max());


    }
}
