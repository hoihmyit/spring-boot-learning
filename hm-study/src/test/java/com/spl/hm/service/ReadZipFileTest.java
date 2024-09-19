package com.spl.hm.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ReadZipFileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadZipFileTest.class);
    public static List<String> AGENCY = Arrays.asList("agency_id,agency_name,agency_url,agency_timezone,agency_lang,agency_phone".split(","));
    public static List<String> CALENDAR_DATES = Arrays.asList("service_id,date,exception_type".split(","));
    public static List<String> FEED_INFO = Arrays.asList("feed_publisher_name,feed_publisher_url,feed_lang,feed_version,feed_start_date,feed_end_date".split(","));
    public static List<String> ROUTES = Arrays.asList("route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color".split(","));
    public static List<String> STOP_TIMES = Arrays.asList("trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type".split(","));
    public static List<String> STOPS = Arrays.asList("stop_id,stop_name,stop_desc,stop_lat,stop_lon,zone_id,stop_url,location_type,parent_station,stop_timezone".split(","));
    public static List<String> TRIPS = Arrays.asList("route_id,service_id,trip_id,trip_headsign,trip_short_name,block_id".split(","));

    @Test
    public void testReadZipFile() {

        File gtfsZipFile = new File(getClass().getClassLoader().getResource("gtfs.zip").getFile());

        if (gtfsZipFile.exists()) {
            // a sub-directory of the download directory
            File unpackDirectory = new File(gtfsZipFile.getParent(), gtfsZipFile.getName().replace(".zip", ""));

            LOGGER.info("Unpacking GTFS data from: {}", gtfsZipFile.getName());
            // Unpack the download zip file into a sub-directory of the download directory
            ZipUtil.unpack(gtfsZipFile, unpackDirectory);

            if (unpackDirectory.listFiles() != null) {
                LOGGER.info("Downloaded and extracted {} files", Objects.requireNonNull(unpackDirectory.listFiles()).length);
            } else {
                LOGGER.error("Download did not extract any files");
            }

            // Read txt files
            ReadGTFSFiles(new File(unpackDirectory, "agency.txt"), AGENCY, "agency");
            ReadGTFSFiles(new File(unpackDirectory, "calendar_dates.txt"), CALENDAR_DATES, "calendar_dates");
            ReadGTFSFiles(new File(unpackDirectory, "feed_info.txt"), FEED_INFO, "feed_info");
            ReadGTFSFiles(new File(unpackDirectory, "routes.txt"), ROUTES, "routes");
            ReadGTFSFiles(new File(unpackDirectory, "stop_times.txt"), STOP_TIMES, "stop_times");
            ReadGTFSFiles(new File(unpackDirectory, "stops.txt"), STOPS, "stops");
            ReadGTFSFiles(new File(unpackDirectory, "trips.txt"), TRIPS, "trips");
        }
    }

    private void ReadGTFSFiles(File agencyFile, List<String> columns, String fileName) {
        if (agencyFile.exists()) {
            try {
                Reader fileReader = new InputStreamReader(new BOMInputStream(new FileInputStream(agencyFile)), StandardCharsets.UTF_8);
                Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader);

                if (records.iterator().hasNext()) {
                    List<String> headers = new ArrayList<>();
                    List<String[]> columnValues = new ArrayList<>();
                    Map<String, List<String[]>> map = new LinkedHashMap<>();

                    for (CSVRecord record : records) {
                        // collect the header data
                        if (CollectionUtils.isEmpty(headers)) {
                            headers = new ArrayList(record.toMap().keySet());
                        }

                        String[] result = new String[record.size()];
                        List<String> finalHeaders = headers;
                        int i = 0;
                        for (String column : columns) {
                            if (finalHeaders.contains(column)) {
                                result[i] = Optional.ofNullable(record.get(column)).orElse("");
                                i++;
                            }
                        }
                        columnValues.add(result);
                    }

                    map.put(fileName, columnValues);
                    System.out.println(map);
                }

                fileReader.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
