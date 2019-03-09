.class public Lzbc/com/andfixdemo/MainActivity_CF;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lzbc/com/andfixdemo/MainActivity$Demo;
    }
.end annotation


# instance fields
.field btnBug:Landroid/widget/Button;
    .annotation build Lbutterknife/Bind;
        value = {
            0x7f070021
        }
    .end annotation
.end field

.field btnRepair:Landroid/widget/Button;
    .annotation build Lbutterknife/Bind;
        value = {
            0x7f070022
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method private initData()V
    .locals 0

    .line 42
    return-void
.end method

.method private loadMethod()V
    .locals 3
    .annotation runtime Lcom/alipay/euler/andfix/annotation/MethodReplace;
        clazz = "zbc.com.andfixdemo.MainActivity"
        method = "loadMethod"
    .end annotation

    .line 45
    new-instance v0, Lzbc/com/andfixdemo/MainActivity$Demo;

    const-string v1, "\u540d\u79f0"

    const-string v2, "\u6210\u529f"

    invoke-direct {v0, p0, v1, v2}, Lzbc/com/andfixdemo/MainActivity$Demo;-><init>(Lzbc/com/andfixdemo/MainActivity;Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    .local v0, "demo":Lzbc/com/andfixdemo/MainActivity$Demo;
    if-nez v0, :cond_0

    .line 48
    const-string v1, "\u7a7a\u6307\u9488\u4e86"

    invoke-static {v1}, Lcom/ztsc/commonutils/toast/ToastUtils;->showToastShort(Ljava/lang/String;)V

    .line 49
    return-void

    .line 51
    :cond_0
    invoke-virtual {v0}, Lzbc/com/andfixdemo/MainActivity$Demo;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/ztsc/commonutils/toast/ToastUtils;->showToastShort(Ljava/lang/String;)V

    .line 54
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .annotation build Lbutterknife/OnClick;
        value = {
            0x7f070021,
            0x7f070022
        }
    .end annotation

    .line 59
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 64
    :pswitch_0
    invoke-static {}, Lzbc/com/andfixdemo/util/FileUtils;->getApkUpdataPath()Ljava/lang/String;

    move-result-object v0

    .line 65
    .local v0, "apkUpdataPath":Ljava/lang/String;
    invoke-static {}, Lzbc/com/andfixdemo/andfix/AndfixPatchManger;->getInstance()Lzbc/com/andfixdemo/andfix/AndfixPatchManger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "/andfix_patcha_1.apatch"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lzbc/com/andfixdemo/andfix/AndfixPatchManger;->addPatch(Ljava/lang/String;)V

    .line 66
    goto :goto_0

    .line 61
    .end local v0    # "apkUpdataPath":Ljava/lang/String;
    :pswitch_1
    invoke-direct {p0}, Lzbc/com/andfixdemo/MainActivity_CF;->loadMethod()V

    .line 62
    nop

    .line 69
    :goto_0
    return-void

    :pswitch_data_0
    .packed-switch 0x7f070021
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 34
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 35
    const v0, 0x7f09001b

    invoke-virtual {p0, v0}, Lzbc/com/andfixdemo/MainActivity_CF;->setContentView(I)V

    .line 36
    invoke-static {p0}, Lbutterknife/ButterKnife;->bind(Landroid/app/Activity;)V

    .line 37
    invoke-direct {p0}, Lzbc/com/andfixdemo/MainActivity_CF;->initData()V

    .line 38
    return-void
.end method
