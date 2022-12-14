package NhomTTPTT.example.BaiTapCuoiKi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import com.example.otpverification.R;

import java.util.ArrayList;
import java.util.List;

import NhomTTPTT.example.BaiTapCuoiKi.repository.ListDowLoad;
import NhomTTPTT.example.BaiTapCuoiKi.repository.Listfavorite;

public class ActivityDetail extends AppCompatActivity {
    TextView txtNameMovie,txtSumary;
    ImageButton imgmp4;
    ImageView imgDowLoad,imgFavorite,imgShare;
    VideoView vdView;

    private GridView gridView;
    private AdapterDiscover adapterDiscover;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtNameMovie =(TextView) findViewById(R.id.txt_detailNameMovie);
        txtSumary =(TextView) findViewById(R.id.txt_Summary);
        imgmp4 =(ImageButton) findViewById(R.id.imgmp4);
        imgDowLoad =(ImageView) findViewById(R.id.imgDowLoad);
        imgShare =(ImageView) findViewById(R.id.imgShare);
        imgFavorite =(ImageView) findViewById(R.id.imgYeuThich);
        vdView = (VideoView) findViewById(R.id.vd_ViDeoMP4);

        Intent intent =getIntent();
        txtNameMovie.setText(intent.getStringExtra("key1"));
        txtSumary.setText(intent.getStringExtra("key2"));
        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT,"Chia se ngay"+" :\n\n https://play.google.com/store/apps/details?id=com.netflix.mediaclient");
                startActivity(Intent.createChooser(sendIntent,"Choose one"));
            }
        });

        imgmp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgmp4.setVisibility(View.INVISIBLE);

                switch (txtNameMovie.getText().toString()) {
                    case "Chi???n Tranh":
                    case "Kinh D???":
                    case "H??i K???ch":
                    case "H??nh ?????ng":
                    case "Cheer Up":
                    case "T??nh C???m":
                    case "Vi???n T?????ng":
                    case "CHERUP":
                    case "Khoa H???c":
                    case "Ho???t H??nh" :{
                        vdView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.chientranh));
                        break;
                    }
                }
                vdView.start();
                MediaController mediaController = new MediaController(ActivityDetail.this);
                mediaController.setMediaPlayer(vdView);
                vdView.setMediaController(mediaController);
            }
        });
        imgDowLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityDetail.this, "T???i xu???ng th??nh c??ng", Toast.LENGTH_SHORT).show();
                    ListDowLoad.movieArrayList.add(new Movie("Chi???n Tranh", R.drawable.ct_chientranh, MovieSummary.CHIENTRANH,"123,4K","00:04:29","","KT- VO KIM THANH"));
            }
        });
        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityDetail.this, "???? th??m v??o danh s??ch y??u th??ch", Toast.LENGTH_SHORT).show();
                Listfavorite.movieArrayList.add(new Movie("Chi???n Tranh", R.drawable.ct_chientranh, MovieSummary.CHIENTRANH,"123,4K","00:04:29","","KT- VO KIM THANH"));
            }
        });

        gridView = (GridView) findViewById(R.id.grViewDetail);
        movieList = new ArrayList<>();
        movieList.add(new Movie("",R.drawable.ct_kinhdi, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM KINH D???"));
        movieList.add(new Movie("",R.drawable.ct_vientuong, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM VI???N T?????NG"));
        movieList.add(new Movie("",R.drawable.ct_hanhdong, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM H??NH ?????NG"));
        movieList.add(new Movie("",R.drawable.ct_phieuluu, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM PHI??U L??U"));
        movieList.add(new Movie("",R.drawable.ct_khoahoc, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM KHOA H???C VI???N T?????NG"));
        movieList.add(new Movie("",R.drawable.ct_trinhtham, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM TRINH TH??M"));
        movieList.add(new Movie("",R.drawable.ct_tinhcam, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM T??NHH C???M"));
        movieList.add(new Movie("",R.drawable.ct_hai, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM H??I"));
        movieList.add(new Movie("",R.drawable.ct_hoathinh, MovieSummary.CHIENTRANH,"123,4K","00:04:29","HO???T H??NH"));
        movieList.add(new Movie("",R.drawable.ct_canhac, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM CA NH???C"));
        movieList.add(new Movie("",R.drawable.ct_anime, MovieSummary.CHIENTRANH,"123,4K","00:04:29","ANIME"));
        movieList.add(new Movie("",R.drawable.ct_chientranh, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM CHI???N TRANH"));
        movieList.add(new Movie("",R.drawable.ct_toipham, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM T???I PH???M" ));
        adapterDiscover= new AdapterDiscover(ActivityDetail.this,0, movieList);
        gridView.setAdapter(adapterDiscover);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityDetail.this, ActivitycategoryDetail.class);
                intent.putExtra("key1", movieList.get(i).getCategory());
                intent.putExtra("key2", movieList.get(i).getImg());
                startActivity(intent);
            }
        });

    }

}