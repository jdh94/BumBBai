package com.cosblog.repository.service.validation;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class ChaeumValidationImpl implements ChaeumValidation {

    @Override
    public HashMap <String, Object> nullValidation(HashMap<String, Object> map) {
        Set <Map.Entry<String, Object>> set = map.entrySet();
        Iterator <Map.Entry<String, Object>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> e = it.next();
            map.put(e.getKey(), e.getValue() == null ? "" : e.getValue());
        }
        return map;
    }

    @Override
    public boolean dateTypeCheck(String type, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(type, Locale.KOREA);
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean inputCheck(String type, String value) {
        boolean flag = false;
        String pattern;
        // 숫자
        if(type.equalsIgnoreCase("NUMBER")) {
            pattern = "^[0-9]*$";
            flag = Pattern.matches(pattern, value);
        }
        // 영문
        else if(type.equalsIgnoreCase("ENGLISH")) {
            pattern = "^[a-zA-Z]*$";
            flag = Pattern.matches(pattern, value);
        }
        // 한글
        else if(type.equalsIgnoreCase("HANGLE")) {
            pattern = "^[ㄱ-ㅎㅏ-ㅣ가-힣]*$";
            flag = Pattern.matches(pattern, value);
        }
        // 숫자, 영문
        else if(type.equalsIgnoreCase("NUMENG")) {
            pattern = "^[a-zA-Z0-9]*$";
            flag = Pattern.matches(pattern, value);
        }
        // 숫자, 한글
        else if(type.equalsIgnoreCase("NUMHAN")) {
            pattern = "^[ㄱ-ㅎㅏ-ㅣ가-힣0-9]*$";
            flag = Pattern.matches(pattern, value);
        }
        // 특수문자
        else if(type.equalsIgnoreCase("SPECIAL_CHAR")) {
            pattern = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*$";
            if(!Pattern.matches(pattern, value)) {
                flag = true;
            } else {
                flag = false;
            }
        }
        // 년도
        else if(type.equalsIgnoreCase("YEAR")) {
            pattern = "^[0-9]*$";
            flag = value.length() == 4 && Pattern.matches(pattern, value) ? true : false;
        }
        return flag;
    }

    @Override
    public boolean isMapParamExistence(final Map<String, Object> map, final boolean isPut, final String... existenceKey) {
        boolean isExistence = true;
        for(int i=0, len=existenceKey.length; i<len; i++) {
            if(!map.containsKey(existenceKey[i]) || map.get(existenceKey[i]) == null || map.get(existenceKey[i]).toString().length() < 1) {
                isExistence = false;
                if(isPut) {
                    map.put(existenceKey[i], "");
                } else {
                    break;
                }
            }
        }
        return isExistence;
    }

    @Override
    public boolean isNull(Object obj) {
        if( obj instanceof String ) {
            return obj == null || obj.toString().trim().length() < 1;
        } else if ( obj instanceof Object[] ) {
            return obj == null || Array.getLength(obj) == 0;
        } else if ( obj instanceof List) {
            return obj == null || ((List<?>) obj).isEmpty();
        } else if ( obj instanceof Map ) {
            return obj == null || ((Map<?, ?>) obj).isEmpty();
        } else {
            return obj == null;
        }
    }

    @Override
    public boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    @Override
    public boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() < 1;
    }

    @Override
    public boolean isNumeric(CharSequence cs) {
        if (isEmpty(cs)) {
            return false;
        }
        for (int i=0, len=cs.length(); i<len; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isMobileNumber(String number) {
        if(this.isNull(number)) return false;
        String regExp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
        return number.matches(regExp);
    }
}
