package id.web.dstwn.retrofitrx.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import id.web.dstwn.retrofitrx.R;
import id.web.dstwn.retrofitrx.data.DataModel;

public class MainActivity extends AppCompatActivity implements MainView{
private MainPresenter presenter;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv_data);
        setPresenter();
        presenter.getData();
    }

    @Override
    public void loading() {

    }

    @Override
    public void showData(DataModel dataModel) {
        textView.setText(dataModel.getName() +","+ dataModel.getProdi() +","+dataModel.getCampus());
    }

    @Override
    public void finishLoading() {

    }
    void setPresenter(){
        presenter= new MainPresenter(this);
    }
}
