package com.yili.IO;

import javax.sound.midi.Soundbank;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Path01 {
    static void show(String id, Object p) {
        System.out.println(id + ":" + p);
    }

    static void info(Path p) {
        show("toString", p);//打印成字符串
        show("Exists", Files.exists(p));//查看是否存在这个路径
        show("Directory", Files.isDirectory(p));//判断是否是文件夹
        show("Absolute", p.isAbsolute());//判断是否是绝对路径
        System.out.println("================================");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path path01 = Paths.get("Path01.java");
        info(path01);
        Path path02 = path01.toAbsolutePath();
        info(path02);
        info(path02.getParent());
        URI u = path01.toUri();
        System.out.println("URI:" + u);
    }
}
