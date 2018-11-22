package Two.LatterTerm.DataStructurePractice.ex10;

import java.util.*;

public class FileEntry {
    private String name;
    private ArrayList<FileEntry> list;

    public FileEntry(String name) {
        this.name = name;
        list = new ArrayList<FileEntry>();
    }

    public String getName() {
        return name;
    }

    public FileEntry add(FileEntry entry) {
        list.add(entry);
        return this;
    }

    public void printList() {
        printList("");
    }

    public void printList(String prefix) {
        // ここを作る
        System.out.println(prefix + "/" + this);
        for (FileEntry file : list) {
            file.printList(prefix + "/" + this);
        }
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        FileEntry rootdir = new FileEntry("root");
        FileEntry bindir = new FileEntry("bin");
        FileEntry tmpdir = new FileEntry("tmp");
        FileEntry usrdir = new FileEntry("usr");
        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);
        bindir.add(new FileEntry("vi"));
        bindir.add(new FileEntry("latex"));
        FileEntry yuki = new FileEntry("yuki");
        FileEntry hanako = new FileEntry("hanako");
        FileEntry tomura = new FileEntry("tomura");
        usrdir.add(yuki);
        usrdir.add(hanako);
        usrdir.add(tomura);
        yuki.add(new FileEntry("diary.html"));
        yuki.add(new FileEntry("Composite.java"));
        hanako.add(new FileEntry("memo.tex"));
        tomura.add(new FileEntry("game.doc"));
        tomura.add(new FileEntry("junk.mail"));
        rootdir.printList();
    }
}
