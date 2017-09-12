package com.leyifu.doubandemo.bean.book;

import java.util.List;

/**
 * Created by xingxing on 2017/9/12.
 */

public class BookBean {

    /**
     * books : [{"alt":"https://book.douban.com/subject/2159604/","alt_title":"","author":["(德)加布里艾勒·格特勒"],"author_intro":"丁娜，北京人，北京大学西语系德语专业七七级毕业，普任北京高等教育出版社德文编辑，慕尼黑大学哲学博士。1995年起从事翻译工作至今，有近百万字文学与社科方面的译作。现居慕尼黑。","binding":"平装","catalog":"","id":"2159604","image":"https://img1.doubanio.com/mpic/s2619459.jpg","images":{"large":"https://img1.doubanio.com/lpic/s2619459.jpg","medium":"https://img1.doubanio.com/mpic/s2619459.jpg","small":"https://img1.doubanio.com/spic/s2619459.jpg"},"isbn10":"7108026988","isbn13":"9787108026989","origin_title":"","pages":"431","price":"28.00元","pubdate":"2007-7","publisher":"","rating":{"average":"8.2","max":10,"min":0,"numRaters":938},"series":{"id":"782","title":"文化生活译丛（新版）"},"subtitle":"","summary":"","tags":[{"count":363,"name":"德国","title":"德国"},{"count":283,"name":"文化","title":"文化"},{"count":194,"name":"三联","title":"三联"},{"count":172,"name":"访谈","title":"访谈"},{"count":146,"name":"寻访行家","title":"寻访行家"},{"count":129,"name":"职业","title":"职业"},{"count":88,"name":"社科","title":"社科"},{"count":62,"name":"外国文学","title":"外国文学"}],"title":"寻访行家","translator":["丁娜","吴鹏飞"],"url":"https://api.douban.com/v2/book/2159604"}]
     * count : 1
     * start : 0
     * total : 200
     */

    private int count;
    private int start;
    private int total;
    private List<BooksBean> books;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", books=" + books +
                '}';
    }
}
