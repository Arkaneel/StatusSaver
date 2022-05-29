package com.arkaneel.statusaver;



import android.Manifest;

import android.animation.*;

import android.app.*;

import android.content.*;

import android.content.ClipData;

import android.content.ClipboardManager;

import android.content.Intent;

import android.content.pm.PackageManager;

import android.content.res.*;

import android.graphics.*;

import android.graphics.drawable.*;

import android.media.*;

import android.net.*;

import android.net.Uri;

import android.os.*;

import android.text.*;

import android.text.style.*;

import android.util.*;

import android.view.*;

import android.view.View.*;

import android.view.animation.*;

import android.webkit.*;

import android.widget.*;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.BaseAdapter;

import android.widget.LinearLayout;

import android.widget.ListView;

import androidx.annotation.*;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import androidx.core.app.ActivityCompat;

import androidx.core.content.ContextCompat;

import androidx.fragment.app.DialogFragment;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;

import com.google.android.material.appbar.AppBarLayout;

import com.sdsmdg.tastytoast.*;

import java.io.*;

import java.text.*;

import java.util.*;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.regex.*;

import org.json.*;



public class MainActivity extends AppCompatActivity {

	
	private Toolbar _toolbar;

	private AppBarLayout _app_bar;

	private CoordinatorLayout _coordinator;

	private double num = 0;

	

	private ArrayList<String> status = new ArrayList<>();

	private ArrayList<HashMap<String, Object>> mappa = new ArrayList<>();

	

	private LinearLayout linear1;

	private ListView listview1;

	

	private Intent nintendo = new Intent();

	

	@Override

	protected void onCreate(Bundle _savedInstanceState) {

		super.onCreate(_savedInstanceState);

		setContentView(R.layout.main);

		initialize(_savedInstanceState);

		

		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);

		} else {

			initializeLogic();

		}

	}

	

	@Override

	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		if (requestCode == 1000) {

			initializeLogic();

		}

	}

	

	private void initialize(Bundle _savedInstanceState) {

		_app_bar = findViewById(R.id._app_bar);

		_coordinator = findViewById(R.id._coordinator);

		_toolbar = findViewById(R.id._toolbar);

		setSupportActionBar(_toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setHomeButtonEnabled(true);

		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {

			@Override

			public void onClick(View _v) {

				onBackPressed();

			}

		});

		linear1 = findViewById(R.id.linear1);

		listview1 = findViewById(R.id.listview1);

		

		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override

			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {

				final int _position = _param3;

				nintendo.setClass(getApplicationContext(), ViewActivity.class);

				nintendo.putExtra("path", mappa.get((int)_position).get("a").toString());

				startActivity(nintendo);

			}

		});

	}

	

	private void initializeLogic() {

		_loadimage();

		setTitle("WhatsApp Status Saver ");

		TastyToast.makeText(getApplicationContext(), "Made By Arkaneel Roy!", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

					

	}

	

	public void _loadimage() {

		FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/WhatsApp/Media/.Statuses"), status);

		for(int _repeat13 = 0; _repeat13 < (int)(status.size()); _repeat13++) {

			if (status.get((int)(num)).contains(".jpg")) {

				{

					HashMap<String, Object> _item = new HashMap<>();

					_item.put("a", status.get((int)(num)));

					mappa.add(_item);

				}

				

				listview1.setAdapter(new Listview1Adapter(mappa));

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

			}

			if (status.get((int)(num)).contains(".mp4")) {

				{

					HashMap<String, Object> _item = new HashMap<>();

					_item.put("a", status.get((int)(num)));

					mappa.add(_item);

				}

				

				listview1.setAdapter(new Listview1Adapter(mappa));

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

			}

			if (status.get((int)(num)).contains(".gif")) {

				{

					HashMap<String, Object> _item = new HashMap<>();

					_item.put("a", status.get((int)(num)));

					mappa.add(_item);

				}

				

				listview1.setAdapter(new Listview1Adapter(mappa));

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

			}

			if (status.get((int)(num)).contains(".mkv")) {

				{

					HashMap<String, Object> _item = new HashMap<>();

					_item.put("a", status.get((int)(num)));

					mappa.add(_item);

				}

				

				listview1.setAdapter(new Listview1Adapter(mappa));

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

			}

			if (status.get((int)(num)).contains(".jpeg")) {

				{

					HashMap<String, Object> _item = new HashMap<>();

					_item.put("a", status.get((int)(num)));

					mappa.add(_item);

				}

				

				listview1.setAdapter(new Listview1Adapter(mappa));

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

			}

			if (status.get((int)(num)).contains(".png")) {

				{

					HashMap<String, Object> _item = new HashMap<>();

					_item.put("a", status.get((int)(num)));

					mappa.add(_item);

				}

				

				listview1.setAdapter(new Listview1Adapter(mappa));

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

			}

			num++;

		}

	}

	

	public class Listview1Adapter extends BaseAdapter {

		

		ArrayList<HashMap<String, Object>> _data;

		

		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {

			_data = _arr;

		}

		

		@Override

		public int getCount() {

			return _data.size();

		}

		

		@Override

		public HashMap<String, Object> getItem(int _index) {

			return _data.get(_index);

		}

		

		@Override

		public long getItemId(int _index) {

			return _index;

		}

		

		@Override

		public View getView(final int _position, View _v, ViewGroup _container) {

			LayoutInflater _inflater = getLayoutInflater();

			View _view = _v;

			if (_view == null) {

				_view = _inflater.inflate(R.layout.custom_view, null);

			}

			

			final LinearLayout linear1 = _view.findViewById(R.id.linear1);

			final LinearLayout linear2 = _view.findViewById(R.id.linear2);

			final TextView textview1 = _view.findViewById(R.id.textview1);

			final ImageView imageview1 = _view.findViewById(R.id.imageview1);

			

			int[] colorsCRNSS = { Color.parseColor("#ffffff"), Color.parseColor("#ffffff") }; android.graphics.drawable.GradientDrawable CRNSS = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colorsCRNSS);

			CRNSS.setCornerRadii(new float[]{(int)33,(int)33,(int)33,(int)33,(int)33,(int)33,(int)33,(int)33});

			CRNSS.setStroke((int) 5, Color.parseColor("#000000"));

			linear1.setElevation((float) 60);

			linear1.setBackground(CRNSS);

			

			//Paste this code in (add source directly block) asd block

			//Milz

			textview1.setText(Uri.parse(mappa.get((int)_position).get("a").toString()).getLastPathSegment());

			if (mappa.get((int)_position).get("a").toString().endsWith(".mp4")) {

				Bitmap bMap = ThumbnailUtils.createVideoThumbnail(mappa.get(_position).get("a").toString(), android.provider.MediaStore.Video.Thumbnails.FULL_SCREEN_KIND); imageview1.setImageBitmap(bMap); 

			}

			else {

				imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(mappa.get((int)_position).get("a").toString(), 1024, 1024));

			}

			

			return _view;

		}

	}

	

	@Deprecated

	public void showMessage(String _s) {

		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();

	}

	

	@Deprecated

	public int getLocationX(View _v) {

		int _location[] = new int[2];

		_v.getLocationInWindow(_location);

		return _location[0];

	}

	

	@Deprecated

	public int getLocationY(View _v) {

		int _location[] = new int[2];

		_v.getLocationInWindow(_location);

		return _location[1];

	}

	

	@Deprecated

	public int getRandom(int _min, int _max) {

		Random random = new Random();

		return random.nextInt(_max - _min + 1) + _min;

	}

	

	@Deprecated

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {

		ArrayList<Double> _result = new ArrayList<Double>();

		SparseBooleanArray _arr = _list.getCheckedItemPositions();

		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {

			if (_arr.valueAt(_iIdx))

			_result.add((double)_arr.keyAt(_iIdx));

		}

		return _result;

	}

	

	@Deprecated

	public float getDip(int _input) {

		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());

	}

	

	@Deprecated

	public int getDisplayWidthPixels() {

		return getResources().getDisplayMetrics().widthPixels;

	}

	

	@Deprecated

	public int getDisplayHeightPixels() {

		return getResources().getDisplayMetrics().heightPixels;

	}

}
