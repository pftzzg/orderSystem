<!DOCTYPE html>
<title>登陆页面</title>
<head>
    <meta content="text/html;charset=UTF-8" />
    <title></title>
</head>
<body>
<form name="/user/register" method="post">
    <table align="center">
        <tr>
            <td>用户注册</td>
        </tr>
        <tr>
            <td>账号：</td>
            <td><input type="text" name ="username"   value="${username?default('')}" size="24"/></td>
        </tr>

        <tr>
            <td>真实名称：</td>
            <td><input type="text" name ="realName"   value="${realName?default('')}" size="24"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"      size="24"/></td>
        </tr>

        <tr>
            <td>联系电话：</td>
            <td><input type="text" name ="mobile" value="${mobile?default('')}" size="24"/></td>
        </tr>
        <tr>
            <td>email：</td>
            <td><input type="text" name="email"  value="${email?default('')}"  size="24"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="提交" size="24"/>
                ${msg?default('')}
                <a href="/user/login" target="_self">登录</a>

            </td>
        </tr>
    </table>
</form>
</body>
</html>