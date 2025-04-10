package com.suri.catest.july20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {


        Employee e1 = new Employee(25, "A", "SSE");
        Employee e2 = new Employee(25, "A", "SSE");

        Employee e3 = new Employee(25, "B", "SSE");
        Employee e4 = new Employee(25, "A", "SSE");

        System.out.println(e3.equals(e4));

        System.out.println(e1 + " " + e2);
        System.out.println(e1.equals(e2));

        Person p1 = new Person(25, "A");
        Person p2 = new Person(25, "A");
        System.out.println(p1.equals(e1));

        System.out.println(p1.equals(p2));

        String[] test = {"GB,2","AF,4","AL,5","DZ,6","AS,7","AD,8","AO,9","AQ,10","AI,11","AG,12","AR,13","AM,14","AW,15","AU,16","AT,17","AZ,18","BS,19","BH,20","BD,21","BB,22","BY,23","BE,24","BZ,25","BJ,26","BM,27","BT,28","BO,29","BA,30","BW,31","BV,32","BR,33","IO,34","BN,35","BG,36","BF,37","BI,38","KH,39","CM,40","CV,42","KY,43","CF,44","TD,45","CL,46","CN,47","CX,48","CC,49","CO,50","KM,51","CG,52","CD,53","CK,54","CR,55","CI,56","HR,57","CU,58","CY,59","CZ,60","DK,61","DJ,62","DM,63","DO,64","TL,65","EC,66","EG,67","SV,68","GQ,69","ER,70","EE,71","ET,72","FK,73","FO,74","FJ,75","FI,76","FR,77","GF,79","PF,80","TF,81","GA,82","GM,83","GE,84","DE,85","GH,86","GI,87","GR,88","GL,89","GD,90","GP,91","GU,92","GT,93","GN,94","GW,95","GY,96","HT,97","HM,98","VA,99","HN,100","HK,101","HU,102","IS,103","IN,104","ID,105","IR,106","IQ,107","IE,108","IL,109","IT,110","JM,111","JP,112","JO,113","KZ,114","KE,115","KI,116","KP,117","KR,118","KW,119","KG,120","LA,121","LV,122","LB,123","LS,124","LR,125","LY,126","LI,127","LT,128","LU,129","MO,130","MK,131","MG,132","MW,133","MY,134","MV,135","ML,136","MT,137","MH,138","MQ,139","MR,140","MU,141","YT,142","MX,143","FM,144","MD,145","MC,146","MN,147","MS,148","MA,149","MZ,150","MM,151","NA,152","NR,153","NP,154","NL,155","NC,157","NZ,158","NI,159","NE,160","NG,161","NU,162","NF,163","MP,164","NO,165","OM,166","PK,167","PW,168","PA,169","PG,170","PY,171","PE,172","PH,173","PN,174","PL,175","PT,176","PR,177","QA,178","RE,179","RO,180","RU,181","RW,182","KN,183","LC,184","VC,185","WS,186","SM,187","ST,188","SA,189","SN,190","SC,191","SL,192","SG,193","SK,194","SI,195","SB,196","SO,197","ZA,198","GS,199","ES,200","LK,201","SH,202","PM,203","SD,204","SR,205","SJ,206","SZ,207","SE,208","CH,209","SY,210","TW,212","TJ,213","TZ,214","TH,215","TG,216","TK,217","TO,218","TT,219","TN,220","TR,221","TM,222","TC,223","TV,224","UG,225","UA,226","AE,227","UM,228","UY,229","UZ,230","VU,231","VE,232","VN,233","VG,234","VI,235","WF,236","EH,237","YE,238","ZM,240","ZW,241","BL,308","BQ,309","CW,310","GG,311","IM,312","JE,313","ME,314","MF,315","PS,316","RS,317","SX,318","SS,319","US,10000","CA,10001","EU,3","DH,7701","HS,1801","HP,1802","ND,1803","NM,1804","JK,1805","XX,10005","xx,10006","xy,10007","iv,10009","JS,1806","AY,1807","PP,10010","NN,10011","vv,10012","AZ,12345","IU,10013"};
        Map<String, Integer> map = new HashMap<>();
        for(String str : test){
            String key = str.split(",")[0];
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue()>1) {
                result.add(entry.getKey());
            }
        }
        System.out.println(result);




    }
    }