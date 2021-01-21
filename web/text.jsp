<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/11/16
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 验证码 -->
<tr>
    <td nowrap width="437"></td>
    <td>
        <img id="img" src="authImage" />
        <a href='#' onclick="javascript:changeImg()" style="color:white;"><label style="color:black;">看不清？</label></a>
    </td>
</tr>


<!-- 触发JS刷新-->
<script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img");
        img.src = "authImage?date=" + new Date();;
    }
</script>
