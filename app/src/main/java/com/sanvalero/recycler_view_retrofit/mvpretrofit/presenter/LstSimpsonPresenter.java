package com.sanvalero.recycler_view_retrofit.mvpretrofit.presenter;

import com.sanvalero.recycler_view_retrofit.mvpretrofit.LstSimpsonContract;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.entities.Simpson;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.model.LstSimpsonModel;

import java.util.ArrayList;

public class LstSimpsonPresenter implements LstSimpsonContract.Presenter {
    private LstSimpsonModel lstSimpsonModel;
    private LstSimpsonContract.View view;

    public LstSimpsonPresenter(LstSimpsonContract.View view) {
        this.view = view;
        lstSimpsonModel = new LstSimpsonModel();
    }

    @Override
    public void lstSimpson(Simpson simpson) {
        lstSimpsonModel.lstSimpsonWS(simpson, new LstSimpsonContract.Model.OnLstSimpsonListener() {
            @Override
            public void onSuccess(ArrayList<Simpson> lstSimpson) {
                if (lstSimpson != null && lstSimpson.size() > 0) {
                    view.successLstSimpson(lstSimpson, "He recogido los datos correctamente!!!");
                } else {
                    view.failureLstSimpson("Los datos no han llegado correctamente!!!");
                }
            }

            @Override
            public void onFailure(String error) {
                view.failureLstSimpson("Error al recoger los datos!!!");
            }
        });
    }
}
