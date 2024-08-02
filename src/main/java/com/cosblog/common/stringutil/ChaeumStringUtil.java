package com.cosblog.common.stringutil;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class ChaeumStringUtil {

    /**
     * 배열을 특정 구분자를 통해 String으로 변환한다.
     *
     * @param arr 배열
     * @param sep 구분자
     * @return 구분자로 구성된 String
     */
    public static String join(String[] arr, char sep) {
        return Arrays.asList(arr).stream().collect(Collectors.joining(Character.toString(sep)));
    }



}
