package com.sanvalero.recycler_view_retrofit.mvpretrofit;

import com.sanvalero.recycler_view_retrofit.mvpretrofit.entities.Simpson;

import java.util.ArrayList;

public interface LstSimpsonContract {
    public interface View{
        void successLstSimpson(ArrayList<Simpson> lstSimpson, String msg);
        void failureLstSimpson(String err);
    }
    public interface Presenter{
        // CASO DE USO
        void lstSimpson(Simpson simpson);
    }
    public interface Model{
        interface OnLstSimpsonListener{
            void onSuccess(ArrayList<Simpson> lstSimpson);
            void onFailure(String error);
        }
        void lstSimpsonWS(Simpson simpson, OnLstSimpsonListener onLstSimpsonListener);
    }
}
