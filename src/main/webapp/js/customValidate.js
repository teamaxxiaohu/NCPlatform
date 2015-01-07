/**
 * validateBox 自定义验证
 * 
 * @author LGH
 */

/**
 * 自定义验证API： 1、 CHS： validType="CHS" 限制只能输入汉字 2、 IP： validType="IP"
 * 验证IP地址，四段数字，以.分隔 3、 lu： validType="lu[n, m]" 验证字符串UTF-8长度，n最小输入长度,m最大输入长度 4、
 * hexLengthwithComma validType="hexLengthwithComma" 验证8位16进制数字,多个的话以英文逗号分隔 5、
 * numOnly validType="numOnly" 验证只能输入正整数 6、 numLength validType="numLength[n,
 * m]" 验证只能输入正整数,长度在n-m之间 7、 fraction validType="fraction[n]"
 * 验证只能输入正小数,小数部分长度最大n位
 */
$.extend($.fn.validatebox.defaults.rules, {
	// 验证汉字
	CHS : {
		validator : function(value) {
			return /^[\u0391-\uFFE5]+$/i.test(value);
		},
		message : '只能输入汉字!'
	},
	// 验证IP
	IP : {
		validator : function(value) {
			return /d+.d+.d+.d+/i.test(value);
		},
		message : 'IP地址格式不正确!'
	},
	// 验证UTF-8字符串长度
	lu : {
		validator : function(value, param) {
			var str = $.trim(value);
			var sum = 0, charCode = -1;
			for (var i = 0; i < str.length; i++) {
				charCode = str.charCodeAt(i);
				if (charCode >= 0 && charCode <= 128) {
					sum += 1;
				} else {
					sum += 3;
				}
			}
			return sum >= param[0] && sum <= param[1];
		},
		message : '内容的UTF-8长度{0}-{1}.'
	},
	// 验证8位16进制数字,以英文逗号分隔
	hexLengthwithComma : {
		validator : function(value) {
			return /^(?:[A-Fa-f0-9]){8}(?:,(?:[A-Fa-f0-9]){8})*$/i.test(value);
		},
		message : '请输入8位16进制数字,多个以英文逗号分隔.'
	},
	// 只能输入正整数
	numOnly : {
		validator : function(value) {
			return /^([1-9][0-9]*)$/i.test(value);
		},
		message : '只能输入正整数.'
	},
	// 只能输入长度为n-m的正整数
	numLength : {
		validator : function(value, param) {
			var v = $.trim(value);
			return /^[1-9]*$/i.test(v) && v.length >= param[0]
					&& v.length <= param[1];
		},
		message : '只能输入长度{0}-{1}的正整数.'
	},

	// 整数或浮点数
	float : {
		validator : function(value) {
			return /^\d+(\.\d+)?$/.test(value);
		},
		message : '只能输入整数或浮点数'
	},

	// 输入小数,限制小数位
	fraction : {
		validator : function(value, param) {
			var v = $.trim(value);
			var parts = value.split('.');
			return /^\d+\.\d+$/i.test(v) && parts[1].length <= param[0];
		},
		message : '只能输入小数,小数部分最多保留{0}位.'
	},
	// e-mail
	email : {
		validator : function(value) {
			var v = $.trim(value);
			return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/i.test(v);
		},
		message : '请输入格式正确的邮箱地址.'
	},
	// telephone
	telephone : {
		validator : function(value) {
			return /^((\d{3,4})|\d{3,4}-)?\d{7,8}$/i.test(value);
		},
		message : '只能输入例如028-1234567或者11位手机号码.'
	},
	// noCNComma
	noCNComma : {
		validator : function(value, param) {
			return /^(?!.，)*$/i.test(value) && param[0] >= alue.length
					&& param[1] <= value.length;
		},
		message : '不能输入中英文逗号.'
	},
	// hex
	hex : {
		validator : function(value, param) {
			return /^[0-9a-fA-F]*$/i.test(value);
		},
		message : '请输入正确的{0}-{1}的十六进制数字.'
	},
	// postcode
	postcode : {
		validator : function(value) {
			return /^[1-9]\d{5}(?!\d)$/i.test(value);
		},
		message : '请输入正确的邮政编码.'
	}

});