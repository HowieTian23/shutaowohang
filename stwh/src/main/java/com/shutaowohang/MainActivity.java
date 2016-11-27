package com.shutaowohang;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import com.shutaowohang.adapter.MyFragmentAdapter;
import com.shutaowohang.fragment.BookFragment;
import com.shutaowohang.fragment.KnowledgeFragment;
import com.shutaowohang.fragment.MeFragment;
import com.shutaowohang.fragment.MessageFragment;
import com.shutaowohang.fragment.SkillFragment;

public class MainActivity extends AppCompatActivity {
  private MyFragmentAdapter adapter;
  private ViewPager viewPager;
  private BookFragment bookFragment = null;
  private KnowledgeFragment knowledgeFragment = null;
  private MeFragment meFragment = null;
  private MessageFragment messageFragment = null;
  private SkillFragment skillFragment = null;
  private RadioGroup radioGroup = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initialFragment();
    setListener();
  }

  private void setListener() {
    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override public void onPageSelected(int position) {
        switch (position) {
          case 0:
            radioGroup.check(R.id.main_radiobutton_knowledge_01);
            break;
          case 1:
            radioGroup.check(R.id.main_radiobutton_skill_02);
            break;
          case 2:
            radioGroup.check(R.id.main_radiobutton_book_03);
            break;
          case 3:
            radioGroup.check(R.id.main_radiobutton_message_04);
            break;
          case 4:
            radioGroup.check(R.id.main_radiobutton_me_05);
            break;
          default:
            break;
        }
      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    });

    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
          case R.id.main_radiobutton_knowledge_01:
            viewPager.setCurrentItem(0);
            break;
          case R.id.main_radiobutton_skill_02:
            viewPager.setCurrentItem(1);
            break;
          case R.id.main_radiobutton_book_03:
            viewPager.setCurrentItem(2);
            break;
          case R.id.main_radiobutton_message_04:
            viewPager.setCurrentItem(3);
            break;
          case R.id.main_radiobutton_me_05:
            viewPager.setCurrentItem(4);
            break;
          default:
            break;
        }
      }
    });
  }

  private void initialFragment() {
    adapter = new MyFragmentAdapter(getSupportFragmentManager());
    viewPager = (ViewPager) findViewById(R.id.main_viewpager);
    viewPager.setOffscreenPageLimit(5);
    radioGroup = (RadioGroup) findViewById(R.id.main_bottom_radiogroup);
    bookFragment = new BookFragment();
    knowledgeFragment = new KnowledgeFragment();
    meFragment = new MeFragment();
    messageFragment = new MessageFragment();
    skillFragment = new SkillFragment();

    adapter.addFragment(knowledgeFragment);
    adapter.addFragment(skillFragment);
    adapter.addFragment(bookFragment);
    adapter.addFragment(messageFragment);
    adapter.addFragment(meFragment);

    viewPager.setAdapter(adapter);
    viewPager.setCurrentItem(4);
  }
//在主界面直接返回桌面
  @Override public void onBackPressed() {
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_MAIN);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.addCategory(Intent.CATEGORY_HOME);
    startActivity(intent);
  }
}
