package com.vrevankar.sample.exercise_01;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

/**
 * Created by vinay on 6/6/17.
 */
public class SortLogFile {


    static String[][] log = {
            { "[2015-11-19 10:33:54.934+0000] [HOST1] [INFO] [CLASS1] [MESSAGE1 something]" },
            { "[2015-11-19 10:31:55.128+0000] [HOST2] [ERROR] [CLASS2] [MESSAGE2 random]" },
            { "[2015-11-19 10:31:55.128+0000] [HOST3] [INFO] [CLASS6] [MESSAGE5 from another host]" },
            { "[2015-11-19 10:37:55.246+0000] [HOST2] [WARN] [CLASS9] [MESSAGE9 again]" },
            { "[2015-11-19 10:35:55.267+0000] [HOST4] [INFO] [CLASS4] [MESSAGE4 too]" },
            { "[2015-11-19 10:22:55.307+0000] [HOST1] [ERROR] [CLASS5] [some error happened]" },
            { "[2015-11-19 10:18:55.377+0000] [HOST5] [INFO] [CLASS1] [MESSAGE1 status message]" },
            { "[2015-11-19 10:31:55.128+0000] [HOST7] [WARN] [CLASS3] [MESSAGE7 something fishy]"},
            { "[2015-11-19 10:43:55.667+0000] [HOST9] [INFO] [CLASS7] [MESSAGE8 normal message]" },
            { "[2015-11-19 10:32:55.782+0000] [HOST1] [ERROR] [CLASS1] [MESSAGE3 another error]" },
    };

    public static void main(String ... args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSZ");
        LocalDateTime time1;

        for(int k1=0; k1<log.length; ++k1){
            String[] words = log[k1][0].split("] \\[");
            String msg = words[2];
            time1 = LocalDateTime.parse(words[0].substring(1), formatter);

            for(int k2=k1+1; k2<log.length; ++k2) {
                String[] words2 = log[k2][0].split("] \\[");
                String msg2 = words2[2];
                LocalDateTime time2 = LocalDateTime.parse(words2[0].substring(1), formatter);
                if(time2.isBefore(time1)){
                  String[] tmp = log[k1];
                  log[k1] = log[k2];
                  log[k2] = tmp;

//                  LocalDateTime time = time1;
                  time1 = time2;
//                  time2 = time;

                }
            }

            System.out.println("Kisna");

        }


    }

}
