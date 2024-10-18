package com.example.demo.commonController;

import com.example.demo.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/test")
@Slf4j
@AllArgsConstructor
public class TestController {

    private TestService testService;

    @RequestMapping("/map")
    public String map() throws IOException, ParseException {
        Reader reader = new FileReader("C:\\multipart\\file.json");

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray data = (JSONArray) jsonObject.get("DATA");

        List<HashMap<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            JSONObject item = (JSONObject) data.get(i);

            HashMap<String, Object> map = new HashMap<>();

            map.put("lastmodts", item.get("lastmodts") != null ? String.valueOf(item.get("lastmodts")) : "");
            map.put("dtlstatenm", item.get("dtlstatenm") != null ? String.valueOf(item.get("dtlstatenm")) : "");
            map.put("totepnum", item.get("totepnum") != null ? String.valueOf(item.get("totepnum")) : "");
            map.put("wmeipcnt", item.get("wmeipcnt") != null ? String.valueOf(item.get("wmeipcnt")) : "");
            map.put("bplcnm", item.get("bplcnm") != null ? String.valueOf(item.get("bplcnm")) : "");
            map.put("maneipcnt", item.get("maneipcnt") != null ? String.valueOf(item.get("maneipcnt")) : "");
            map.put("isream", item.get("isream") != null ? String.valueOf(item.get("isream")) : "");
            map.put("jtupsoasgnno", item.get("jtupsoasgnno") != null ? String.valueOf(item.get("jtupsoasgnno")) : "");
            map.put("faciltotscp", item.get("faciltotscp") != null ? String.valueOf(item.get("faciltotscp")) : "");
            map.put("jtupsomainedf", item.get("jtupsomainedf") != null ? String.valueOf(item.get("jtupsomainedf")) : "");
            map.put("multusnupsoyn", item.get("multusnupsoyn") != null ? String.valueOf(item.get("multusnupsoyn")) : "");
            map.put("clgenddt", item.get("clgenddt") != null ? String.valueOf(item.get("clgenddt")) : "");
            map.put("sitearea", item.get("sitearea") != null ? String.valueOf(item.get("sitearea")) : "");
            map.put("dcbymd", item.get("dcbymd") != null ? String.valueOf(item.get("dcbymd")) : "");
            map.put("clgstdt", item.get("clgstdt") != null ? String.valueOf(item.get("clgstdt")) : "");
            map.put("trdstategbn", item.get("trdstategbn") != null ? String.valueOf(item.get("trdstategbn")) : "");
            map.put("trdstatenm", item.get("trdstatenm") != null ? String.valueOf(item.get("trdstatenm")) : "");
            map.put("apvcancelymd", item.get("apvcancelymd") != null ? String.valueOf(item.get("apvcancelymd")) : "");
            map.put("sitepostno", item.get("sitepostno") != null ? String.valueOf(item.get("sitepostno")) : "");
            map.put("fctysiljobepcnt", item.get("fctysiljobepcnt") != null ? String.valueOf(item.get("fctysiljobepcnt")) : "");
            map.put("opnsfteamcode", item.get("opnsfteamcode") != null ? String.valueOf(item.get("opnsfteamcode")) : "");
            map.put("sitetel", item.get("sitetel") != null ? String.valueOf(item.get("sitetel")) : "");
            map.put("fctypdtjobepcnt", item.get("fctypdtjobepcnt") != null ? String.valueOf(item.get("fctypdtjobepcnt")) : "");
            map.put("sitewhladdr", item.get("sitewhladdr") != null ? String.valueOf(item.get("sitewhladdr")) : "");
            map.put("dtlstategbn", item.get("dtlstategbn") != null ? String.valueOf(item.get("dtlstategbn")) : "");
            map.put("rdnpostno", item.get("rdnpostno") != null ? String.valueOf(item.get("rdnpostno")) : "");
            map.put("bdngownsenm", item.get("bdngownsenm") != null ? String.valueOf(item.get("bdngownsenm")) : "");
            map.put("trdpjubnsenm", item.get("trdpjubnsenm") != null ? String.valueOf(item.get("trdpjubnsenm")) : "");
            map.put("homepage", item.get("homepage") != null ? String.valueOf(item.get("homepage")) : "");
            map.put("monam", item.get("monam") != null ? String.valueOf(item.get("monam")) : "");
            map.put("fctyowkepcnt", item.get("fctyowkepcnt") != null ? String.valueOf(item.get("fctyowkepcnt")) : "");
            map.put("updategbn", item.get("updategbn") != null ? String.valueOf(item.get("updategbn")) : "");
            map.put("updatedt", item.get("updatedt") != null ? String.valueOf(item.get("updatedt")) : "");
            map.put("apvpermymd", item.get("apvpermymd") != null ? String.valueOf(item.get("apvpermymd")) : "");
            map.put("wtrsplyfacilsenm", item.get("wtrsplyfacilsenm") != null ? String.valueOf(item.get("wtrsplyfacilsenm")) : "");
            map.put("lvsenm", item.get("lvsenm") != null ? String.valueOf(item.get("lvsenm")) : "");
            map.put("uptaenm", item.get("uptaenm") != null ? String.valueOf(item.get("uptaenm")) : "");
            map.put("hoffepcnt", item.get("hoffepcnt") != null ? String.valueOf(item.get("hoffepcnt")) : "");
            map.put("rdnwhladdr", item.get("rdnwhladdr") != null ? String.valueOf(item.get("rdnwhladdr")) : "");
            map.put("sntuptaenm", item.get("sntuptaenm") != null ? String.valueOf(item.get("sntuptaenm")) : "");
            map.put("x", item.get("x") != null ? String.valueOf(item.get("x")) : "");
            map.put("y", item.get("y") != null ? String.valueOf(item.get("y")) : "");
            map.put("ropnymd", item.get("ropnymd") != null ? String.valueOf(item.get("ropnymd")) : "");
            map.put("mgtno", item.get("mgtno") != null ? String.valueOf(item.get("mgtno")) : "");
            list.add(map);
        }

        log.info(list.toString());
        log.info(String.valueOf(list.size()));

        //testService.insertItems(list);

        return "board/map";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity<?> selList() {
        return ResponseEntity.ok(testService.selList());
    }
}
