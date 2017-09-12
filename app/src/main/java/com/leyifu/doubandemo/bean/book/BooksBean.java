package com.leyifu.doubandemo.bean.book;

import java.util.List;

/**
 * Created by xingxing on 2017/9/12.
 */
public class BooksBean {
    /**
     * alt : https://book.douban.com/subject/2159604/
     * alt_title :
     * author : ["(德)加布里艾勒·格特勒"]
     * author_intro : 丁娜，北京人，北京大学西语系德语专业七七级毕业，普任北京高等教育出版社德文编辑，慕尼黑大学哲学博士。1995年起从事翻译工作至今，有近百万字文学与社科方面的译作。现居慕尼黑。
     * binding : 平装
     * catalog :
     * id : 2159604
     * image : https://img1.doubanio.com/mpic/s2619459.jpg
     * images : {"large":"https://img1.doubanio.com/lpic/s2619459.jpg","medium":"https://img1.doubanio.com/mpic/s2619459.jpg","small":"https://img1.doubanio.com/spic/s2619459.jpg"}
     * isbn10 : 7108026988
     * isbn13 : 9787108026989
     * origin_title :
     * pages : 431
     * price : 28.00元
     * pubdate : 2007-7
     * publisher :
     * rating : {"average":"8.2","max":10,"min":0,"numRaters":938}
     * series : {"id":"782","title":"文化生活译丛（新版）"}
     * subtitle :
     * summary :
     * tags : [{"count":363,"name":"德国","title":"德国"},{"count":283,"name":"文化","title":"文化"},{"count":194,"name":"三联","title":"三联"},{"count":172,"name":"访谈","title":"访谈"},{"count":146,"name":"寻访行家","title":"寻访行家"},{"count":129,"name":"职业","title":"职业"},{"count":88,"name":"社科","title":"社科"},{"count":62,"name":"外国文学","title":"外国文学"}]
     * title : 寻访行家
     * translator : ["丁娜","吴鹏飞"]
     * url : https://api.douban.com/v2/book/2159604
     */

    private String alt;
    private String alt_title;
    private String author_intro;
    private String binding;
    private String catalog;
    private String id;
    private String image;
    private ImagesBean images;
    private String isbn10;
    private String isbn13;
    private String origin_title;
    private String pages;
    private String price;
    private String pubdate;
    private String publisher;
    private RatingBean rating;
    private SeriesBean series;
    private String subtitle;
    private String summary;
    private String title;
    private String url;
    private List<String> author;
    private List<TagsBean> tags;
    private List<String> translator;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public SeriesBean getSeries() {
        return series;
    }

    public void setSeries(SeriesBean series) {
        this.series = series;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    @Override
    public String toString() {
        return "BooksBean{" +
                "alt='" + alt + '\'' +
                ", alt_title='" + alt_title + '\'' +
                ", author_intro='" + author_intro + '\'' +
                ", binding='" + binding + '\'' +
                ", catalog='" + catalog + '\'' +
                ", id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", images=" + images +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", origin_title='" + origin_title + '\'' +
                ", pages='" + pages + '\'' +
                ", price='" + price + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", publisher='" + publisher + '\'' +
                ", rating=" + rating +
                ", series=" + series +
                ", subtitle='" + subtitle + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", author=" + author +
                ", tags=" + tags +
                ", translator=" + translator +
                '}';
    }
}
