$('.srch_box input').focus(function(){
    $('.srch_box').addClass('border_blue');
  }
).blur(function(){
    $('.srch_box').removeClass('border_blue')
  }
);
// 右侧悬浮菜单
$('.more_brands').hover(function(){
  $('.brand_list').show();
});
$('.brand_list').mouseover(function(){
  $('.brand_list').show()
}).mouseout(function(){
  $('.brand_list').hide();
});
// pop菜单的显示与隐藏
$('.srch_set').prev().mouseover(function(){
  $('.srch_set').show();
});
$('#header').mouseout(function() {
  $('.srch_set').hide();
});
///////////////////////
// 提示文字 和 相关事件
$('.hint_box').find('*').css('display','none');

$('#username').blur(check_username).focus(function(){
  $('#username').addClass('border_blue');
  $('.username_line .reg_hint').css('display','none');
  $('.username_line .long_hint').css('display','none');
  $('.username_line .error_hint').css('display','none');
  $('.username_line i').removeClass().css("display","none");
  $('.username_line .ipt_hint').css('display','inline-block');}
  );

// username验证函数
var regUser = /(?![\d]*$)[\w\u4e00-\u9fa5]{1,14}/;//7位汉字或者14位英文
var allNumber = /^\d+$/;

function check_username(){
  var ipt = $('#username').val();//获取用户输入的用户名
  var ipt_len = 0;
  // 检查用户名是否为空
  function isEmpty(){
    if(ipt == ''){
      $('#username').removeClass();
      $('.username_line .ipt_hint').css('display','none');
      return false;
    }else {
      return true;
    }
  }
  //检查字节长度是否 符合要求
  function check_length(){
    for (var i = 0; i<ipt.length; i++) {
      if (ipt.charCodeAt(i) >= 0 && ipt.charCodeAt(i) <= 128) {
        ipt_len++;
      } else {
        ipt_len += 2;
      }
    }//计数字节数
    if(ipt_len<=14){
      $('#username').removeClass();
      $('.username_line .ipt_hint').css('display','none');
      // $('.username_line i').attr('class','green').css('display','inline-block');
      return true;
    }else{
      $('.username_line .ipt_hint').css('display','none');
      $('.username_line .reg_hint').css('display','none');
      $('.username_line i').attr('class','red').css('display','inline-block');
      $('.username_line .long_hint').css('display','inline-block');
      console.log('长度超出');
      return false;
    }
  }
  //检查是否全为数字
  function isAllNumber(){
    if(allNumber.test(ipt)){
      $('#username').addClass('border_red');
      $('.username_line .ipt_hint').css('display','none');
      $('.username_line i').attr('class','red').css('display','inline-block');
      $('.username_line .reg_hint').css('display','inline-block');
      console.log("不能全是数字")
      return false;
    }else {
      $('#username').addClass('border_blue');
      $('.username_line .ipt_hint').css('display','none');
      // $('.username_line i').attr('class','red').css('display','none');
      // $('.username_line i').attr('class','green').css('display','inline-block');
      $('.username_line .reg_hint').css('display','none');
      return true;
    }
  }
  //检查唯一性
  function check_name_unique(){
    $.get('../register/unique', "ipt:"+ipt, function(response){
      // console.log(response);
      return response.data;
    });
  }
  //最终检查
  if(isEmpty() &&check_length() && isAllNumber() ){
    console.log("可用！");
    $("#username").removeClass();
    $('.username_line .hint_box i').css('display','inline-block')
      .attr('class','green');
    // $(".username_line .hint_box").css("display","inline-block");
    $(".username_line .ipt_hint").css("display","none");
    $(".username_line .reg_hint").css("display","none");
    $(".username_line .long_hint").css("display","none");
    return true;
  }

}
///////////////////////////////////////
//验证手机号
$('#phone').blur(check_phone).focus(function(){
  $('#phone').addClass('border_blue');
  $('.phone_line .ipt_hint').css('display','inline-block');
  $('.phone_line .error_hint').css('display','none');
  $(".phone_line .hint_box i").css("display","none");
});
var phoneReg = /^[1][3578][\d]{9}$/;
function check_phone(){
  var ipt = $("#phone").val();
  //检测是否输入号码
  function isBlank(){
    if(ipt==""){
      $("#phone").removeClass();
      $(".phone_line .ipt_hint").css("display","none");
      console.log("手机号为空");
      return false;
    }else {
      return true;
    }
  }
  //检查号码 是否满足正则表达式
  function isLegal(){
    if(phoneReg.test(ipt)){
      $(".phone_line .hint_box i").removeClass().addClass("green");
      $(".phone_line .ipt_hint").css("display","none");
      $(".phone_line .hint_box i").removeClass().addClass("green")
        .css("display","inline-block");
      return true;
    }else{
      $("#phone").removeClass().addClass("border_red");
      $(".phone_line .error_hint").css("display","inline-block");
      $(".phone_line .ipt_hint").css("display","none");
      $(".phone_line .hint_box i").removeClass().addClass("red")
        .css("display","inline-block");;
      console.log("手机号格式错误");
      return false;
    }
  }
  if(isBlank() && isLegal()){
    $(".phone_line .hint_box i").removeClass().addClass("green")
      .css("display","inline-block");
    $("#phone").removeClass();
    return true;
  }
}


////////////////////////////////////////
// 绑定事件
$('#pwd').blur(check_pwd).focus(function(){
  $('#pwd').attr('class','border_blue');
  $('.pwd_line .reg_hint').css('display','none');
  $('.pwd_line .ipt_hint').css('display','inline-block')
    .find('*').css('display','block');
});
$('#pwd').on('input propertychange',check_pwd);

var regNum = /^[\d]{6,14}$/;
function check_pwd(){
  var pwd = $('#pwd').val();
// 检查 用户是否输入
  function check_pwd_isBlank(){
    if(pwd==''){
      $('#pwd').removeClass();
      $('.pwd_line .ipt_hint').css('display','none')
        .find('*').css('display','none');
      $('.pwd_line .verify_pass').css('display','none');
      return false;
    }else {
      return true;
    }
  }
// 检查输入的长度
  function check_pwd_length(){
    if(pwd.length<6 || pwd.length>14){
      $('.pwd_line li:first-child').css('color','#fc4343');
      $('#pwd').removeClass();
      $('.pwd_line .verify_pass').css('display','none');
      return false;
    }else{
      $('.pwd_line li:first-child').css('color','#666');
      return true;
    }
  }
// 检查输入值是否包含空格
  function check_pwd_hasBlank(){
    if(pwd.indexOf(' ')>0){
      $('.pwd_line li:last-child').css('color','#fc4343');
      $('#pwd').removeClass();
      $('.pwd_line .verify_pass').css('display','none');
      return false;
    }else {
      $('.pwd_line li:last-child').css('color','#666');
      return true;
    }
  }
// 检查密码强度
  function check_pwd_strength(){
    if(regNum.test(pwd)){
      $('.pwd_line .ipt_hint').css('display','none');
      $('.pwd_line .reg_hint').css('display','block')
        .find('*').css('display','block');
      $('.pwd_line i').addClass('red');
      $('#pwd').addClass('border_red');
      $('.pwd_line .verify_pass').css('display','none');
      return false;
    }else{ return true;}
  }
  if(check_pwd_isBlank() && check_pwd_hasBlank() && check_pwd_length() && check_pwd_strength()){
    $('.pwd_line .ipt_hint').css('display','none');
    $('.pwd_line .reg_hint').css('display','none');
    $('.pwd_line .verify_pass').addClass('green').css('display','block');
    $("#pwd").removeClass();
    return true;
  }
}



///////////////////
/////////////验证码
$('.pop_close').click(function(){
	$('.pop_code_bg').css('display','none');
	$('.pop_code_wrapper').css('display','none');
});
if($('.pop_code_bg:hidden')){
	$('#get_code').click(function(){
    $('.code_box').attr('src','../register/validate_code');//获取图片
    $('.pop_code_bg').css('display','block');
    $('.pop_code_wrapper').css('display','block');
	});
}
$('.reload_code').mouseup(function(){
  $.get('../register/validate_code',function(){
    $('.code_box').attr('src','../register/validate_code');
  })
});

//验证码提交验证
$('#code_submit').mouseup(function(){
  var ipt = $('#code_input').val();
  $.post('../register/validate_code','code='+ipt,function(response){
    console.log(response);
    console.log("ipt:"+ipt);
    // console.log(response.body);
    if(ipt==''){
      $('#code_input').addClass('border_red');
      //红色框加不上去怎么回事？？？
      console.log('验证码为空');
      $('.pop_code_body .code_hint').css('display','inline-block');
      $('.pop_code_body .code_error').css('display','none');
      $('.pop_code_body .no_code').css('display','inline-block');
    }else if(response.data=='false'){
      console.log('验证码错误');
      $('.pop_code_body #code_input').removeClass().addClass('border_red');
      $('.pop_code_body .code_hint').css('display','inline-block');
      $('.pop_code_body .no_code').css('display','none');
      $('.pop_code_body .code_error').css('display','inline-block');
    }else {
      $('.pop_code_body .code_hint').css('display','none');
      $(".pop_code_wrapper").css("display","none");
      $(".pop_code_bg").css("display","none");
      $("#verify_code").val(ipt);
      console.log("验证成功");
    }
  });
});

//表单提交验证
// function check_form(){
//   if(check_username() && check_phone() && check_pwd() && $("#check_proto:checked").length>0){
//     return true;
//   }else {
//     return false;
//   }
//   console.log(check_username())
//   console.log(check_pwd())
//   console.log(check_phone())
// }
var obj = {
    "accountName" : $("#username").val(),
    "mail": "",
    "phoneNumber" : $("#phone").val(),
    "password" : $("#pwd").val()
    };

$("#submit").mouseup(function(){
  console.info(JSON.stringify(obj)) ;
  $.ajax({
    type: "post",
    // url: "http://localhost:8080/register",
    url: "../register",
    contentType: "application/json",
    // dataType: "json",
    data: JSON.stringify(obj),
    success: function(data){
      console.log("注册成功");
      console.log(data);
    },
    error: function(errorThrown){
     console.log(errorThrown);
    }

  });
});
// 跳转到登录界面
$(".log_link button").click(

);



