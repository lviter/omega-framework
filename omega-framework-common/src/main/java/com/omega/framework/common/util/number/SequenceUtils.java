package com.omega.framework.common.util.number;

import com.omega.framework.common.util.json.JsonUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Author lviter
 * @Description 分布式自增id设计思路
 * @Date 17:54 2021/6/24
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class SequenceUtils {

    /**
     * 补位数
     */
    public static final int DEFAULT_LENGTH = 10;

    /**
     * 补位0算法
     *
     * @param seq
     * @return
     */
    public static String getSequence(long seq) {
        String str = String.valueOf(seq);
        int len = str.length();
        if (len >= DEFAULT_LENGTH) {
            return str;
        }
        int rest = DEFAULT_LENGTH - len;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rest; i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * 时间自增id生成器(建议使用cache，做分布式id)
     *
     * @return
     */
    public static Long dateIdGenerator() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String current = LocalDateTime.now().format(df);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return Long.parseLong(current.concat(getSequence(atomicInteger.incrementAndGet())));
    }

    /**
     * 按批生成id
     *
     * @param size
     * @return
     */
    public static List<Long> generateBatch(int size) {
        List<String> longs = new ArrayList<>();
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < size; i++) {
            longs.add(currentDate.concat(SequenceUtils.getSequence(atomicInteger.incrementAndGet())));
        }
        return longs.stream().map(Long::parseLong).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(dateIdGenerator());
        System.out.println(JsonUtils.objectData2json(generateBatch(20)));
    }
}
