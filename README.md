# ContributionView

## 运行效果

图

## 添加依赖

### 在project的build.gradle添加如下代码

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### 在app的build.gradle中添加如下代码

```
	dependencies {
	        implementation 'com.gitee.Hancher:contribution-view:1.0'
	}
```

## 默认方案

### xml文件

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".activity.AccountActivity">

    <com.hancher.contribution.ContributionView
        android:id="@+id/contributionView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

只需要固定宽度，高度会自动调整，因此高度使用包裹即可。

因此可以根据个人需要，将其用横向滚动布局包裹，扩大横向固定宽度，实现左右滑动，在此不再一一实验。

### java调用

```java
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        List<ContributionView.Item> data = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 3 - 1, 1);
        Date startDate = calendar.getTime();
        for (int i = 0; i < 121; i++) {
            data.add(new ContributionView.Item(calendar.getTime(),i % 5));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        binding.contributionView.setData(startDate, data);
    }
```

## 其他接口

通过配置实体类，修改样式

```
setData(Date startDate, List<ContributionItem> data, ContributionConfig config)
```

配置接口

```java
        ContributionConfig config = new ContributionConfig()
                .setBorderWidth(2)//边框宽度
                .setBorderColor(0xFF9E9E9E)//边框颜色
                .setItemRound(5)//圆角矩形圆半径
                .setMonths(new String[]{"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"})//月份字符串
                .setPadding(4)//单个框宽度
                .setRank(new int[]{0,2,5,8,10})//颜色等级范围，大于等于2小于5则为第二个颜色范围
                .setRankColor(new int[]{0xFFEBEDF0, 0xFF9BE9A8, 0xFF40C463, 0xFF30A14E, 0xFF216E39})//填充的等级颜色
                .setWeeks(new String[]{"", "周一", "", "周三", "", "周五", ""})//周名称
                .setStartOfWeek(Calendar.SUNDAY)//配合setWeeks一起使用，可以实现第一行为周日，默认第一行周一
                .setTxtColor(0xFF9E9E9E);//设置文字颜色
```

配置点击监听

```java
        binding.contributionView.setOnItemClick(new ContributionView.OnItemClickListener() {
            @Override
            public void onClick(int position, ContributionItem item) {
                Toast.makeText(ContributionActivity.this, position + ":" + item.getRow() + "," + item.getCol(), Toast.LENGTH_SHORT).show();
            }
        });
```



## 备注

如果你觉得这个库还不错,请赏我一颗star吧

如果star超过1k，或者有打赏，那我再回头看看增加一些其他功能



纵向贡献图表

动画