package cn.kobe.bryant.service;
import cn.kobe.bryant.domain.Books;
import cn.kobe.bryant.domain.Comment;
import cn.kobe.bryant.domain.MyFavourite;
import cn.kobe.bryant.domain.NewWorld;

import java.util.List;
import java.util.Map;


public interface BookService {
    List findAll(String text, int currentPage, int count);

    public int getCount(String text);

    public List findAllBooks(int currentPage, int i);

    public int getAllBooksCount();

    public Books findBookByName(String book_name);

    public List<Map<String, Object>> findBookByList(String list);

    public MyFavourite findMyFavourite(String book_name, int id);

    public void collectionFavouriteBook(String book_name, int id);

    public void deleteFavouriteBook(String book_name, int id);

    public List<NewWorld> findAllReadExperience();

    public List findComment(String book_name,String category);

    public void addComment(Comment comment);

    public void deleteComment(String id);

    public List findNewBooks(int nums);

    public NewWorld findReadExperience(String topic, String username, String time);

    public List newExpressServlet();

    public List newExpressByCategory(String book_name);

    /**
     * findAllBooks方法的重载，该方法返回所有图书
     * @return
     */
    public List findAllBooks();

    public int getCountByOther();

    public List findAllBooksByOther(int currentPage, int limit);

    public int giveLikeToBookComment(int comment_id, int id);

    public boolean isGiveLike(int comment_id, int id);

    public int deleteUserLike(int comment_Id, int id);
}
