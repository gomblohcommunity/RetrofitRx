package id.web.dstwn.retrofitrx.main;

import id.web.dstwn.retrofitrx.data.DataModel;

public interface MainView {
    void loading();
    void showData(DataModel dataModel);
    void finishLoading();
}
