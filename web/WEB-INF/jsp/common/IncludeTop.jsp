<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/11/14
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css"
          media="screen" />
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="viewCart"><img align="middle" name="img_cart" src="images/cart.gif" /></a>
            <img align="middle" src="images/separator.gif" />
            <a href="viewSignOn">Sign In</a>
            <a href="viewSignOut">Sign Out</a>
            <img align="middle" src="images/separator.gif" />
            <a href="viewMyAccount">My Account</a>
            <img align="middle" src="images/separator.gif" />
            <a href="../help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="Search" method="post">
                <input type="text" name="keyword" id="input" size="14"/><input type="submit" name="searchProducts" value="Search" />
            </form>
        </div>
    </div>

    <script type="text/javascript">
        $(function() {
            var availableTags = ["Amazon Parrot","Finch","Koi","Goldfish","Angelfish","Tiger Shark","Persian","Manx","Bulldog","Chihuahua","Dalmation","Poodle","Golden Retriever","Labrador Retriever","Iguana","Rattlesnake"];
            $( "#input" ).autocomplete({
                source:
                    function(request, response) {
                        var results = $.ui.autocomplete.filter(availableTags, request.term);
                        response(results.slice(0, 10));//只显示自动提示的前十条数据
                    },
                messages: {
                    noResults: '',
                    results: function() {}
                },
            });

        });
    </script>






    <div id="QuickLinks">
        <a href="ViewCategory?categoryId=FISH"><img
                src="images/sm_fish.gif" /></a> <img src="images/separator.gif" />
        <a href="ViewCategory?categoryId=DOGS"><img
                src="images/sm_dogs.gif" /></a> <img src="images/separator.gif" />
        <a href="ViewCategory?categoryId=REPTILES"><img
                src="images/sm_reptiles.gif" /></a> <img
            src="images/separator.gif" /> <a href="ViewCategory?categoryId=CATS"><img
            src="images/sm_cats.gif" /></a> <img src="images/separator.gif" />
        <a href="ViewCategory?categoryId=BIRDS"><img src="images/sm_birds.gif" /></a>
    </div>
</div>

<div id="Content">

