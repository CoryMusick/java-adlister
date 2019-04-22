import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
private Connection connection;


public MySQLAdsDao(Config config) {
       try{
           DriverManager.registerDriver(new Driver());
           connection = DriverManager.getConnection(
                   Config.getUrl(),
                   Config.getUsername(),
                   Config.getPassword()
           );
       }catch(SQLException e){
           throw new RuntimeException("error connecting to database", e);
    }
    }
    // get a list of all the ads
    @Override
    public List<Ad> all(){
        List<Ad> ads = new ArrayList<>();
        try{
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
        while(rs.next()){
           Ad ad = new Ad(rs.getInt("id"), rs.getInt("user_id"),
                   rs.getString("title"),rs.getString("description"));
        ads.add(ad);
        }
    }catch(SQLException e){
        System.out.println(e);
        }
    return ads;
}
    // insert a new ad and return the new ad's id
    @Override
    public Long insert(Ad ad){
        Long newId = null;
        try{
            String query = "INSERT INTO ads(user_id, title, description) VALUES (?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, ad.getUserId());
            pstmt.setString(2, ad.getTitle());
            pstmt.setString(3, ad.getDescription());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            newId = rs.getLong(1);
        }catch(SQLException e){
            System.out.println(e);
        }
        return newId;
    }

}
