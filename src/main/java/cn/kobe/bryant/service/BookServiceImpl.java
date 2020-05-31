package cn.kobe.bryant.service;

import cn.kobe.bryant.Dao.BookDao;
import cn.kobe.bryant.Dao.BookDaoImpl;
import cn.kobe.bryant.domain.Books;
import cn.kobe.bryant.domain.Comment;
import cn.kobe.bryant.domain.MyFavourite;
import cn.kobe.bryant.domain.NewWorld;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements  BookService {
    private BookDao dao = new BookDaoImpl();

    /**
     * 通过模糊查询 查找所有符合条件的图书
     * @param text
     * @param currentPage
     * @param count
     * @return
     */
    @Override
    public List findAll(String text,int currentPage,int count) {
        return dao.findAll(text,currentPage,count);
    }

    /**
     * 取得指定类型的图书的数量
     * @param text
     * @return
     */
    @Override
    public int getCount(String text) {
        return dao.getCount(text);
    }

    /**
     * 取得每一页所有的图书的列表
     * @param currentPage
     * @param i
     * @return
     */
    @Override
    public List findAllBooks(int currentPage, int i) {
        return dao.findAllBooks(currentPage,i);
    }

    /**
     * 取得所有图书的数量
     * @return
     */
    @Override
    public int getAllBooksCount() {
        return  dao.getAllBooksCount();
    }

    /**
     * 通过搜索查询
     * @param book_name
     * @return
     */
    @Override
    public Books findBookByName(String book_name) {
        return dao.findBookByName(book_name);
    }

    /**
     * 查询不同的榜单的图书的列表
     * @param list
     * @return
     */
    @Override
    public List<Map<String, Object>> findBookByList(String list) {
        return dao.findBookByList(list);
    }


    /**
     *  查看图书是否被收藏
     * @param book_name
     * @param id
     * @return
     */
    @Override
    public MyFavourite findMyFavourite(String book_name, int id) {
        return dao.findMyFavourite(book_name,id);
    }

    /**
     * 收藏图书
     * @param book_name
     */
    @Override
    public void collectionFavouriteBook(String book_name,int id) {
        dao.collectionFavouriteBook(book_name,id);
    }

    /**
     * 不收藏图书
     * @param book_name
     */

    @Override
    public void deleteFavouriteBook(String book_name,int id) {
        dao.delelteFavouriteBook(book_name,id);
    }

    @Override
    public List<NewWorld> findAllReadExperience() {
        return dao.findAllReadExperience();
    }

    /**
     * 查找每本书的评论
     * @param book_name
     * @return
     */
    @Override
    public List findComment(String book_name,String category) {
        return dao.findComment(book_name,category);
    }

    @Override
    public void addComment(Comment comment) {
       dao.addComment(comment);
    }

    @Override
    public void deleteComment(String id) {
        dao.deleteComment(id);
    }

    @Override
    public List findNewBooks(int nums) {
        return dao.findNewBooks(nums);
    }

    @Override
    public NewWorld findReadExperience(String topic, String username, String time) {
        return dao.findReadExperience(topic,username,time);
    }

    @Override
    public List newExpressServlet() {
        return dao.newExpressServlet();
    }

    @Override
    public List newExpressByCategory(String book_name) {
        return dao.newExpressByCategory(book_name);
    }

    @Override
    public List findAllBooks() {
        return dao.findAllBooks();
    }

    @Override
    public int getCountByOther() {
        return dao.getCountByOther();
    }

    @Override
    public List findAllBooksByOther(int currentPage, int limit) {
        return dao.findAllBooksByOther(currentPage,limit);
    }

    @Override
    public int giveLikeToBookComment(int comment_id, int id) {
        return dao.giveLikeToBookComment(comment_id,id);
    }

    @Override
    public boolean isGiveLike(int comment_id, int id) {
        return dao.isGiveLike(comment_id,id);
    }

    @Override
    public int deleteUserLike(int comment_Id, int id) {
        return dao.deleteUserLike(comment_Id,id);
    }


}
