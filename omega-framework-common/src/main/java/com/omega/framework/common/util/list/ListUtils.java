package com.omega.framework.common.util.list;

import com.omega.framework.common.util.ReflectUtils;

import java.util.*;

/**
 * @author lviter
 */
public class ListUtils {

    /**
     * 根据属性值去重，支持String类型
     *
     * @param list  要去重的集合
     * @param field 根据去重的字段
     * @param <T>
     * @return
     */
    public static <T> List<T> removeDupliByField(List<T> list, String field) {
        Set<T> personSet = new TreeSet<>(Comparator.comparing(o -> ReflectUtils.getValue(o, field).toString()));
        personSet.addAll(list);
        return new ArrayList<>(personSet);
    }

    /**
     * list去重复元素
     *
     * @param ioList
     */
    public static void duplicateRemoval(List<String> ioList) {
        LinkedHashSet<String> tmpSet = new LinkedHashSet<>(ioList.size());
        tmpSet.addAll(ioList);
        ioList.clear();
        ioList.addAll(tmpSet);
    }

    /**
     * 分割集合
     *
     * @param list      待分割的集合
     * @param groupSize 分割集合长度
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int groupSize) {
        int length = list.size();
        // 计算可以分成多少组
        int num = (length + groupSize - 1) / groupSize;
        List<List<T>> newList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = Math.min((i + 1) * groupSize, length);
            newList.add(list.subList(fromIndex, toIndex));
        }
        return newList;
    }

    /**
     * 校验集合内是否有重复数据 true 有重复 false 无重复
     *
     * @param list  要校验的集合
     * @param field 要校验的字段
     * @param <T>
     * @return
     */
    public static <T> boolean validateDupliByField(List<T> list, String field) {
        return removeDupliByField(list, field).size() < list.size();
    }
}
