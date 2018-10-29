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

$('#username').blur(check_username).focus(
  function(){
  $('#username').addClass('border_blue');
    $('.username_line .reg_hint').css('display','none');
    $('.username_line .long_hint').css('display','none');
    $('.username_line .error_hint').css('display','none');
    $('.username_line i').css('display','none');
    $('.username_line .ipt_hint').css('display','inline-block');}
  );

// username验证函数
var regUser = /(?![\d]*$)[\w\u4e00-\u9fa5]{1,14}/; //7位汉字或者14位英文
function check_username(){
  var ipt = $('#username').val();//获取用户输入的用户名
  var ipt_len = 0;
  if(ipt == ''){
    $('#username').removeClass();
    $('.username_line .ipt_hint').css('display','none');
  }
  else if(regUser.test(ipt)){
    for(var i=0; i<ipt.length; i++){
      if(ipt.charCodeAt(i)>=0 && ipt.charCodeAt(i)<=128){
        ipt_len++;
      }else { ipt_len+=2;}
    }
    if(ipt_len<=14){
      $('#username').removeClass();
      $('.username_line .ipt_hint').css('display','none');
      $('.username_line i').attr('class','green').css('display','inline-block');
    }else{
      $('.username_line .ipt_hint').css('display','none');
      $('.username_line .reg_hint').css('display','none');
      $('.username_line i').attr('class','red').css('display','inline-block');
      $('.username_line .long_hint').css('display','inline-block');
    }
  }else {
    $('#username').addClass('border_red');
    $('.username_line .ipt_hint').css('display','none');
    $('.username_line i').attr('class','red').css('display','inline-block');
    $('.username_line .reg_hint').css('display','inline-block');
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
  }
  console.log(regNum.test(pwd));
}

///////////////////////////////////////
//验证手机号
$('#phone').blur(check_phone).focus(function(){
  $('#phone').addClass('border_blue');
  $('.phone_line .ipt_hint').css('display','inline-block');
});
function check_phone(){

}

///////////////////
/////////////验证码
$('.pop_close').click(function(){
	$('.pop_code_bg').css('display','none');
	$('.pop_code_wrapper').css('display','none');
});
if($('.pop_code_bg:hidden')){
	$('#get_code').click(function(){
		$('.pop_code_bg').css('display','block');
		$('.pop_code_wrapper').css('display','block');
		get_code();
	});
}


function getXhr() {
	var xhr;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActiveXObject('Microsoft.XMLHttp')
	}
	return xhr;
}


function get_code() {
	var xhr = getXhr();
	xhr.open('get', 'http://localhost:8080/user/register/validate_code');
	xhr.send();
	xhr.onreadystatechange = function () {
		if(xhr.readyState==4){
			if(xhr.status==200){
				console.log('111');
			}
		}
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
		}
	}

}