package validat;


import java.util.Map;

/**
 * Created by elwin on 2017/11/8.
 */
public class ValidateFunction {

    private static Map<String,String> message;
    /**
     * 邮箱验证
     */
    public static final String _EMAIL_CHECK ="email_validate";
    /**
     * ip验证
     */
    public static final String _IP_CHECK ="ip_validate";
    /**
     * 网址验证
     */
    public static final String _URL_CHECK ="url_validate";
    /**
     * 电话号验证
     */
    public static final String _TEL_CHECK ="tel_validate";
    /**
     * 字符长度验证
     */
    public static final String _PASSWLENGTH_CHECK ="passwLength_validate";
    /**
     * 邮编验证
     */
    public static final String _POSTALCODE_CHECK="postalcode_validate";
    /**
     * 手机号验证
     */
    public static final String _HANDSET_CHECK ="handset_validate";
    /**
     * 身份证号验证
     */
    public static final String _IDCARD_CHECK ="idcard_validate";
    /**
     * 两位小数验证
     */
    public static final String _DECIMAL_CHECK ="decimal_validate";
    /**
     * 月份验证
     */
    public static final String _MONTH_CHECK ="month_validate";
    /**
     * 天数验证
     */
    public static final String _DAY_CHECK ="day_validate";
    /**
     * 日期验证
     */
    public static final String _DATE_CHECK ="date_validate";
    /**
     * 数字验证
     */
    public static final String _NUMBER_CHECK ="number_validate";
    /**
     * 正整数验证
     */
    public static final String _INTNUMBER_CHECK ="intNumber_validate";
    /**
     * 大写字母验证
     */
    public static final String _UPCHAR_CHECK ="upChar_validate";
    /**
     * 小写字母验证
     */
    public static final String _LOWCHAR_CHECK ="lowChar_validate";
    /**
     * 字母验证
     */
    public static final String _LETTER_CHECK ="letter_validate";
    /**
     * 汉字验证
     */
    public static final String _CHINESE_CHECK ="chinese_validate";
    /**
     * 字符串验证
     */
    public static final String _STRING_CHECK ="string_validate";
    /**
     * 特殊字符验证
     */
    public static final String _SPECIAL_CHECK ="specialChar_validate";
    /**
     * 中文字符串验证
     */
    public static final String _CHINESESTRING_CHECK ="chineseString_validate";
    /**
     * 账号合法验证
     */
    public static final String _ACCOUNTNAME_CHECK ="accountName_validate";
    /**
     * 非零的负整数验证
     */
    public static final String _MINUSINT_CHECK ="minusInt_validate";
    /**
     * 浮点数验证
     */
    public static final String _FLOAT_CHECK ="float_validate";
    /**
     * txt文件路径验证
     */
    public static final String _TXT_CHECK ="txt_validate";
    /**
     * 16进制颜色验证
     */
    public static final String _COLOR_CHECK ="color_validate";
    /**
     * md5验证
     */
    public static final String _MD5_CHECK ="md5_validate";
    /**
     * 24小时时间验证
     */
    public static final String _TIME_CHECK ="time_validate";
    /**
     * QQ号验证
     */
    public static final String _QQ_CHECK ="QQ_validate";
    /**
     * 十六进制验证
     */
    public static final String _HEX_CHECK ="hex_validate";




/*    static {
        message = new HashMap<String, String>();
        message.put("1","邮箱号码验证错误");

    }

    private Integer valiType;*/

    /**
     *  字符串验证
     * @param type 验证类型（dictionary_value）
     * @param key 字段名称（id）
     * @param str 需要验证的字符串
     * @return
     */
   public static ValidateMessage check(String type,String key,String str){
       ValidateMessage validateMessage = new ValidateMessage();
       boolean result =false;
       switch(type){
           case _EMAIL_CHECK:
               result = ValidateUtils.isEmail(str);
               if (!result){
                   validateMessage.setMessage(key+":邮箱号码验证错误");
               }
               break;
           case _IP_CHECK:
               result = ValidateUtils.isIP(str);
               if (!result){
                   validateMessage.setMessage(key+":IP验证错误");
               }
               break;
           case _URL_CHECK:
               result = ValidateUtils.IsUrl(str);
               if (!result){
                   validateMessage.setMessage(key+":网址验证错误");
               }
               break;
           case _TEL_CHECK:
               result = ValidateUtils.IsTelephone(str);
               if (!result){
                   validateMessage.setMessage(key+":电话号码验证错误");
               }
               break;
           case _PASSWLENGTH_CHECK:
               result = ValidateUtils.IsPasswLength(str);
               if (!result){
                   validateMessage.setMessage(key+":字符长度验证错误");
               }
               break;
           case _POSTALCODE_CHECK:
               result = ValidateUtils.IsPostalcode(str);
               if (!result){
                   validateMessage.setMessage(key+":邮编验证错误");
               }
               break;
           case _HANDSET_CHECK:
               result = ValidateUtils.IsHandset(str);
               if (!result){
                   validateMessage.setMessage(key+":手机号码验证错误");
               }
               break;
           case _IDCARD_CHECK:
               result = ValidateUtils.IsIDcard(str);
               if (!result){
                   validateMessage.setMessage(key+":身份证号验证错误");
               }
               break;
           case _DECIMAL_CHECK:
               result = ValidateUtils.IsDecimal(str);
               if (!result){
                   validateMessage.setMessage(key+":两位小数验证错误");
               }
               break;
           case _MONTH_CHECK:
               result = ValidateUtils.IsMonth(str);
               if (!result){
                   validateMessage.setMessage(key+":月份验证错误");
               }
               break;
           case _DAY_CHECK:
               result = ValidateUtils.IsDay(str);
               if (!result){
                   validateMessage.setMessage(key+":天数验证错误");
               }
               break;
           case _DATE_CHECK:
               result = ValidateUtils.isDate(str);
               if (!result){
                   validateMessage.setMessage(key+":日期验证错误");
               }
               break;
           case _NUMBER_CHECK:
               result = ValidateUtils.IsNumber(str);
               if (!result){
                   validateMessage.setMessage(key+":数字验证错误");
               }
               break;
           case _INTNUMBER_CHECK:
               result = ValidateUtils.IsIntNumber(str);
               if (!result){
                   validateMessage.setMessage(key+":正整数验证错误");
               }
               break;
           case _UPCHAR_CHECK:
               result = ValidateUtils.IsUpChar(str);
               if (!result){
                   validateMessage.setMessage(key+":大写字母验证错误");
               }
               break;
           case _LOWCHAR_CHECK:
               result = ValidateUtils.IsLowChar(str);
               if (!result){
                   validateMessage.setMessage(key+":小写字母验证错误");
               }
               break;
           case _LETTER_CHECK:
               result = ValidateUtils.IsLetter(str);
               if (!result){
                   validateMessage.setMessage(key+":字母验证错误");
               }
               break;
           case _CHINESE_CHECK:
               result = ValidateUtils.IsChinese(str);
               if (!result){
                   validateMessage.setMessage(key+":汉字验证错误");
               }
               break;
           case _STRING_CHECK:
               result = ValidateUtils.IsLength(str);
               if (!result){
                   validateMessage.setMessage(key+":字符串验证错误");
               }
               break;
           case _SPECIAL_CHECK:
               result = ValidateUtils.IsSpecial(str);
               if (!result){
                   validateMessage.setMessage(key+":特殊字符验证错误");
               }
               break;
           case _CHINESESTRING_CHECK:
               result = ValidateUtils.IsChineseString(str);
               if (!result){
                   validateMessage.setMessage(key+":中文字符串验证错误");
               }
               break;
           case _ACCOUNTNAME_CHECK:
               result = ValidateUtils.IsAccountName(str);
               if (!result){
                   validateMessage.setMessage(key+":账户名合法性验证错误");
               }
               break;
           case _MINUSINT_CHECK:
               result = ValidateUtils.IsMinusInt(str);
               if (!result){
                   validateMessage.setMessage(key+":非零负整数验证错误");
               }
               break;
           case _FLOAT_CHECK:
               result = ValidateUtils.IsFloat(str);
               if (!result){
                   validateMessage.setMessage(key+":浮点数验证错误");
               }
               break;
           case _TXT_CHECK:
               result = ValidateUtils.IsTXT(str);
               if (!result){
                   validateMessage.setMessage(key+":TXT文件名验证错误");
               }
               break;
           case _COLOR_CHECK:
               result = ValidateUtils.IsColor(str);
               if (!result){
                   validateMessage.setMessage(key+":颜色验证错误");
               }
               break;
           case _MD5_CHECK:
               result = ValidateUtils.IsMd5(str);
               if (!result){
                   validateMessage.setMessage(key+":md5验证错误");
               }
               break;
           case _TIME_CHECK:
               result = ValidateUtils.IsTime(str);
               if (!result){
                   validateMessage.setMessage(key+":时间验证错误");
               }
               break;
           case _QQ_CHECK:
               result = ValidateUtils.IsQQ(str);
               if (!result){
                   validateMessage.setMessage(key+":QQ验证错误");
               }
               break;
           case _HEX_CHECK:
               result = ValidateUtils.IsHex(str);
               if (!result){
                   validateMessage.setMessage(key+":十六进制验证错误");
               }
               break;



       }
       validateMessage.setResult(result);
       validateMessage.setKey(key);
       return validateMessage;

   }

    /**
     * 邮箱号码验证
     * @param type
     * @param key
     * @param str
     * @return
     */
   /* public static ValidateMessage checkEmail(String type,String key,String str){
        ValidateMessage validateMessage = new ValidateMessage();
        if(_EMAIL_CHECK.equals(type)){
            boolean result = ValidateUtils.isEmail(str);
            validateMessage.setKey(key);
            validateMessage.setResult(result);
            if (!result){
                validateMessage.setMessage(key+":邮箱号码验证错误");
            }
        }
        return validateMessage;
    }*/

    /**
     * IP验证
     * @param type
     * @param key
     * @param str
     * @return
     */
 /*   public static ValidateMessage checkIp(String type,String key,String str){
        ValidateMessage validateMessage = new ValidateMessage();
        if(_IP_CHECK.equals(type)){
            boolean result = ValidateUtils.isIP(str);
            validateMessage.setKey(key);
            validateMessage.setResult(result);
            if (!result){
                validateMessage.setMessage(key+":IP验证错误");
            }
        }
        return validateMessage;
    }

*/

/*    private static ValidateMessage getRES(int type,String key,boolean res){
        ValidateMessage  validateMessage = new ValidateMessage();
        validateMessage.setKey(key);
        validateMessage.setResult(res);
        validateMessage.setMessage(message.get(String.valueOf(type)));
        return validateMessage;
    }*/
}
