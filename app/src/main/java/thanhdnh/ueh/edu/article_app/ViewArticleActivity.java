package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ViewArticleActivity extends AppCompatActivity {
  ImageView iv_detail;
  TextView tv_detail_username;
  TextView tv_detail_email;
  TextView tv_detail_desc;
  TextView tv_detail_hobby;
  TextView tv_detail_id;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_article);
    getSupportActionBar().hide();

    iv_detail = findViewById(R.id.iv_detail);
    tv_detail_username = findViewById(R.id.tv_detail_username);
    tv_detail_email = findViewById(R.id.tv_detail_email);
    tv_detail_desc = findViewById(R.id.tv_detail_desc);
    tv_detail_hobby = findViewById(R.id.tv_detail_hobby);
    tv_detail_id = findViewById(R.id.tv_detail_id);

    int id = (int) getIntent().getLongExtra("id", 0);
    UserProfile user = ArticleData.getUserFromId(id);

    Picasso.get()
            .load(user.getAvatar_url())
            .resize(400, 500)
            .centerCrop()
            .into(iv_detail);

    tv_detail_id.setText("ID: " + user.getId());
    tv_detail_username.setText("Username: " + user.getUsername());
    tv_detail_email.setText("Email: " + user.getEmail());
    tv_detail_desc.setText("Description: " + user.getDesc());
    tv_detail_hobby.setText("Hobby: " + user.getHobby());
  }
}
