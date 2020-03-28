package com.example.kahanikar;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

public class SearchableActivity extends Activity {

    private static Object JARGON;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbar);
        handleIntent(getIntent());
    }
    @Override
    protected void onNewIntent(Intent intent){
        setIntent(intent);
        handleIntent(intent);
    }
        private void handleIntent(Intent intent){
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
             doMySearch(query);
        }
        }
        @Override
        public boolean onSearchRequested(){
         Bundle appData = new Bundle();
         appData.putBoolean((String) SearchableActivity.JARGON, true);
         startSearch(null , false , appData, false);
         return true;
         
        }
        public void refineSearch(){
        Bundle appData = getIntent().getBundleExtra(SearchManager.APP_DATA);
        if(appData != null){
            boolean jargon = appData.getBoolean((String) SearchableActivity.JARGON);
        }
        }


    private void doMySearch(String query) {
        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
        Intent intent = new Intent(this , SearchOperation.class);
        startActivity(intent);
    }
}

