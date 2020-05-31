package cn.kobe.bryant.Dao;
import cn.kobe.bryant.domain.*;
import cn.kobe.bryant.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements  BookDao{
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List findAll(String text,int currentPage,int count) {
        String sql = " select * from books where category like ? or author like ? or name like ? order by name  limit ?,? ";
        text = "%"+text+"%";
        return  template.queryForList(sql,text,text,text,(currentPage-1)*count,count);
    }

    @Override
    public int getCount(String text) {
        String sql = "select count(*) from books where category like ?  or name like ? or author like ?  ";
        text = "%"+text+"%";
        return  template.queryForObject(sql,Integer.class,text,text,text);
    }

    @Override
    public List findAllBooks(int currentPage, int i) {
        String sql = " select * from books order by name limit ?,?  ";
        return  template.queryForList(sql,(currentPage-1)*i,i);
    }

    @Override
    public int getAllBooksCount() {
        String sql = "select count(*) from books ";
        return  template.queryForObject(sql,Integer.class);
    }

    @Override
    public Books findBookByName(String book_name) {

        Books books = null;
        try{
            String sql = "SELECT * FROM books WHERE NAME LIKE ? ";
            book_name = "%"+book_name+"%";
            books = template.queryForObject(sql,new BeanPropertyRowMapper<Books>(Books.class),book_name);
        }catch (Exception e){
        }
        return  books;
    }

    @Override
    public List findBookByList(String list) {
        List list1 = null;
        try{
            String sql = "select * from "+list+" order by grade desc; ";
            list1 = template.queryForList(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list1;
    }

    @Override
    public MyFavourite findMyFavourite(String book_name, int id) {
        MyFavourite myFavourite = null;
        try{
            String sql = "select * from favourite_book where user_id = ? and book_name = ? ";
            myFavourite = template.queryForObject(sql,new BeanPropertyRowMapper<MyFavourite>(MyFavourite.class),id,book_name);
        }catch (Exception e){
        }
        return  myFavourite;
    }

    @Override
    public void collectionFavouriteBook(String book_name, int id) {
        //首先，要查找到要收藏的图书的id，不然无法将收藏的图书放入数据库
        String sql = "select book_id from books where name = ? ";
        int i = template.queryForObject(sql,Integer.class,book_name);
        //将数据放入数据库
        String sql1 = "insert into favourite_book values(?,?,?)";
        template.update(sql1,id,book_name,i);
    }

    @Override
    public void delelteFavouriteBook(String book_name, int id) {
        //将用户收藏的图书从数据库中删除
        String sql = "delete from favourite_book where book_name = ? and user_id = ? ";
        template.update(sql,book_name,id);
    }

    @Override
    public List<NewWorld> findAllReadExperience() {
        String sql = "SELECT user_read_experience.use_id,user_read_experience.book_name, user_read_experience.author,user.user_photo,user.username,user_read_experience.time,user_read_experience.topic,user_read_experience.read_experience FROM USER INNER JOIN user_read_experience ON user.id = user_read_experience.use_id; ";
        return  template.query(sql,new BeanPropertyRowMapper<NewWorld>(NewWorld.class));
    }

    /**
     * 通过书评的编号，获得该评论的所有回复
     * @return
     */
    public List<BookCommentReply> getBookCommentReplys(int comment_id){
        String sql = "";
        List list = null;
        try {
            sql = "SELECT book_comment_reply.`comment_id`,\n" +
                    "book_comment_reply.`good`,book_comment_reply.`id`,\n" +
                    "book_comment_reply.`reply_content`,book_comment_reply.`time`,\n" +
                    "book_comment_reply.`username`,book_comment_reply.`user_image` FROM book_comment_reply,\n" +
                    "books_comment \n" +
                    "WHERE books_comment.`id` = ? AND books_comment.id = book_comment_reply.`comment_id` ;";
            list =template.query(sql,new BeanPropertyRowMapper<BookCommentReply>(BookCommentReply.class),comment_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    @Override
    public List findComment(String book_name,String category) {
        List<Comment> list = null;
       try{
           String sql = "select * from books_comment  where book_name = ? order by "+category+" desc";
           list =  template.query(sql,new BeanPropertyRowMapper<Comment>(Comment.class),book_name);
           for(int i = 0 ; i<list.size();i++){
               int id = list.get(i).getId();
               List<BookCommentReply> commentReply = getBookCommentReplys(id);
               list.get(i).setReplys(commentReply);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return list;
    }

    @Override
    public void addComment(Comment comment) {
        String sql = "insert into books_comment(user_id,book_id,book_comment,username,user_image,time,book_name,good) values (?,?,?,?,?,?,?,?) ";
        template.update(sql,comment.getUser_id(),comment.getBook_id(),comment.getBook_comment(),comment.getUsername(),comment.getUser_image(),comment.getTime(),comment.getBook_name(),comment.getGood());
    }

    @Override
    public void deleteComment(String id) {
        String sql = "delete from books_comment where id = ? ";
        template.update(sql,id);
    }

    @Override
    public List findNewBooks(int nums) {
        String sql = "select * from books order by publication_year desc limit 0,?";
        return template.queryForList(sql,nums);
    }

    @Override
    public NewWorld findReadExperience(String topic, String username, String time) {
        NewWorld world = null;
        try {
            String sql = "SELECT user_read_experience.use_id,user_read_experience.book_name, user_read_experience.author,user.user_photo,user.username,user_read_experience.time,user_read_experience.topic,user_read_experience.read_experience FROM USER INNER JOIN user_read_experience ON user.id = user_read_experience.use_id and user_read_experience.topic = ?  and user_read_experience.use_id = ? and  user_read_experience.time = ? ";
            world = template.queryForObject(sql,new BeanPropertyRowMapper<NewWorld>(NewWorld.class),topic,username,time);
        }catch (Exception e){
            return  null;
        }
        return  world;
    }

    @Override
    public List newExpressServlet() {
        List list = null;
        try {
            String sql = "SELECT * FROM books ORDER BY publication_year DESC LIMIT 8;";
            list = template.queryForList(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List newExpressByCategory(String book_name) {
        List list = null;
        book_name = "%"+book_name+"%";
        try {
            String sql = "SELECT * FROM books where category like ? ORDER BY publication_year DESC LIMIT 8;";
            list = template.queryForList(sql,book_name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List findAllBooks() {
        List<Books> list = null;
        try {
            String sql = "select * from books;";
            list = template.query(sql,new BeanPropertyRowMapper<Books>(Books.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    @Override
    public int getCountByOther() {
        int i = 0;
        try {
            String sql = "SELECT COUNT(*) FROM books WHERE  category NOT IN(SELECT category FROM books WHERE  category LIKE '%漫画%' OR category LIKE '%旅游%' OR category LIKE '%生活%' OR category LIKE '%艺术%' OR category LIKE '%经济%' OR category LIKE '%心理%' OR category LIKE '%IT%' OR  category LIKE '%小说%' OR category LIKE '%戏剧%' OR category LIKE '%诗歌%' OR category LIKE '%散文%');";
            i = template.queryForObject(sql,Integer.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List findAllBooksByOther(int currentPage, int limit) {
        List list = null;
        try {
            String sql  = "SELECT * FROM books WHERE  category NOT IN(SELECT category FROM books WHERE  category LIKE '%漫画%' OR category LIKE '%旅游%' OR category LIKE '%生活%' OR category LIKE '%艺术%' OR category LIKE '%经济%' OR category LIKE '%心理%' OR category LIKE '%IT%' OR  category LIKE '%小说%' OR category LIKE '%戏剧%' OR category LIKE '%诗歌%' OR category LIKE '%散文%') limit ?,?;";
            list = template.queryForList(sql,(currentPage-1)*limit,limit);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int giveLikeToBookComment(int coment_id,int id22) {
        int i = -1;
        try {
            String sql = "UPDATE  books_comment  SET  good = good+1 WHERE id = ? ;";
            i = template.update(sql,coment_id);
            String insert_sql = "insert into comment_favourite(comment_id,user_id) values(?,?)";
            template.update(insert_sql,coment_id,id22);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean isGiveLike(int comment_id, int id) {
        List<Comment_favourite> comment_favourite = null;
        try{
            String sql = "select * from comment_favourite where user_id = ? and comment_id = ? ;";
            comment_favourite = template.query(sql,new BeanPropertyRowMapper<Comment_favourite>(Comment_favourite.class),id,comment_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(comment_favourite.size() == 0){
            return  false;
        }
        else {
            return true;
        }
    }

    @Override
    public int deleteUserLike(int comment_id,int id) {
        int i = -1;
        try {
            String sql = "update books_comment set good = good-1 where id = ? ;";
            template.update(sql,comment_id);
            String new_sql = "delete  from comment_favourite where user_id = ? and comment_id = ?;";
            template.update(new_sql,id,comment_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
