package cn.kobe.bryant.Dao;


import cn.kobe.bryant.domain.Books;
import cn.kobe.bryant.domain.Comment;
import cn.kobe.bryant.domain.MyFavourite;
import cn.kobe.bryant.domain.NewWorld;

import java.util.List;
import java.util.Map;

public interface BookDao {
    /**
     * 模糊查询，查找所有符合条件的图书 （在图书分类时不同的类型 或者搜索的内容都以此来取得结果）
     * @param text
     * @param currentPage
     * @param count
     * @return
     */
    public List  findAll(String text, int currentPage, int count);

    /**
     * 返回符合条件的图书的数量 （在图书分类时不同的类型 或者搜索的内容都以此来取得结果）
     * @param text
     * @return
     */
    public int getCount(String text);

    /**
     * 取得所有图书的集合
     * @param currentPage
     * @param i
     * @return
     */
    public List findAllBooks(int currentPage, int i);

    /**
     * 取得所有图书的数量
     * @return
     */
    public int getAllBooksCount();

    /**
     * 通过搜索查询
     * @param book_name
     * @return
     */
    public Books findBookByName(String book_name);

    /**
     * 取得不同榜单的图书的数量
     * @param list
     * @return
     */
    public List findBookByList(String list);

    /**
     * 查看是否收藏了指定图书
     * @param book_name
     * @param id
     * @return
     */
    public MyFavourite findMyFavourite(String book_name, int id);

    /**
     * 收藏图书
     * @param book_name
     * @param id
     */
    public void collectionFavouriteBook(String book_name, int id);

    /**
     * 不收藏图书
     * @param book_name
     * @param id
     */
    public void delelteFavouriteBook(String book_name, int id);

    public List<NewWorld> findAllReadExperience();

    public List findComment(String book_name,String category);

    public void addComment(Comment comment);

    public void deleteComment(String id);

    public List findNewBooks(int nums);

    public NewWorld findReadExperience(String topic, String username, String time);

    /**
     * 新书速递展示
     * @return
     */
    public List newExpressServlet();

    /**
     * 在浏览器首页，通过点击不同的按钮，来实现不同新书展示
     * @param book_name
     * @return
     */
    public List newExpressByCategory(String book_name);

    public List findAllBooks();

    public int getCountByOther();

    public List findAllBooksByOther(int currentPage, int limit);

    public int giveLikeToBookComment(int comment_id,int id);

    public boolean isGiveLike(int comment_id, int id);

    public int deleteUserLike(int comment_id,int id);
}
