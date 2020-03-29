package com.nibado.fastcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParams {
    public static void main(String... argv) {

        var list = new ArrayList<String>();
        list.addAll(list("equals", true, false));

        list.addAll(list("arrayList", false, false));
        list.addAll(list("array", false, false));
        list.addAll(list("arrayBS", false, false));
        list.addAll(list("javaHashSet"));
        list.addAll(list("hppcHashSet"));
        list.addAll(list("hppcScatterSet"));
        list.addAll(list("troveHashSet"));
        list.addAll(list("fuHashSet"));

        var joined = list.stream().collect(Collectors.joining("\", \"", "@Param({\"", "\"})"));

        System.out.println(joined);
    }

    private static List<String> combine(List<String>... lists) {
        var result = new ArrayList<String>();

        for (var l : lists) {
            result.addAll(l);
        }

        return result;
    }

    private static List<String> list(String implementation) {
        return list(implementation, false, true);
    }

    private static List<String> list(String implementation, boolean singleOnly, boolean loadFactors) {
        var amounts = singleOnly ? List.of("1") : List.of("1", "10", "100", "1000");
        var factors = loadFactors ? List.of("0.75", "0.5", "0.25") : List.of("");

        var list = new ArrayList<String>();
        for (var f : factors) {
            for (var a : amounts) {
                list.add(String.format("%s,%s,%s", implementation, f, a));
            }
        }

        return list;
    }
}
