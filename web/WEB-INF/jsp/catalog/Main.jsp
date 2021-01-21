<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/11/14
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../common/IncludeTop.jsp"%>

<style>
    .clickDiv{
        width: 250px;
        height: 230px;
        text-align: center;
        background-color: aquamarine;
        font-size: 20px;
        position: absolute;
        display: none;
        border-radius: 5px;
        border: 2px solid #6699ff;
    }
</style>


<div id="Welcome">
    <div id="WelcomeContent">
        Welcome to MyPetStore!
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="ViewCategory?categoryId=FISH"><img src="images/fish_icon.gif" /></a>
            <br/> Saltwater, Freshwater <br/>
            <a href="ViewCategory?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a>
            <br /> Various Breeds <br />
            <a href="ViewCategory?categoryId=CATS"><img src="images/cats_icon.gif" /></a>
            <br /> Various Breeds, Exotic Varieties <br />
            <a href="ViewCategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a>
            <br /> Lizards, Turtles, Snakes <br />
            <a href="ViewCategory?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a>
            <br /> Exotic Varieties
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250" href="ViewCategory?categoryId=BIRDS" shape="rect" id="click1"/>
                <area alt="Fish" coords="2,180,72,250" href="ViewCategory?categoryId=FISH" shape="rect" id="click2"/>
                <area alt="Dogs" coords="60,250,130,320" href="ViewCategory?categoryId=DOGS" shape="rect" id="click3"/>
                <area alt="Reptiles" coords="140,270,210,340" href="ViewCategory?categoryId=REPTILES" shape="rect" id="click4"/>
                <area alt="Cats" coords="225,240,295,310" href="ViewCategory?categoryId=CATS" shape="rect" id="click5"/>
                <area alt="Birds" coords="280,180,350,250" href="ViewCategory?categoryId=BIRDS" shape="rect" id="click6"/>
            </map>
            <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
        </div>
    </div>
    <div id="Separator">&nbsp;</div>
</div>
<div class="clickDiv" id="alert1" >
    <h3>Bird</h3>
    <table border="1">
        <tr>
            <td>Product ID</td>
            <td>Name</td>
        </tr>
        <tr>
            <td>AV-CB-01</td>
            <td>AmazonParrot</td>
        </tr>
        <tr>
            <td>AV-SB-02</td>
            <td>Finch</td>
        </tr>
    </table>
</div>
<div class="clickDiv" id="alert2" >
    <h3>Fish</h3>
    <table border="1">
    <tr>
        <td>Product ID</td>
        <td>Name</td>
    </tr>
    <tr>
        <td>FI-FW-01</td>
        <td>Koi</td>
    </tr>
    <tr>
        <td>FI-FW-02</td>
        <td>Goldfish</td>
    </tr>
        <tr>
            <td>FI-SW-01</td>
            <td>Angelfish</td>
        </tr>
        <tr>
            <td>FI-SW-02</td>
            <td>Tiger Shark</td>
        </tr>
    </table>
</div>
<div class="clickDiv" id="alert3" >
    <h3>Dog</h3>
    <table border="1">
        <tr>
            <td>Product ID</td>
            <td>Name</td>
        </tr>
        <tr>
            <td>K9-BD-01</td>
            <td>Bulldog</td>
        </tr>
        <tr>
            <td>K9-CW-01</td>
            <td>Chihuahua</td>
        </tr>
        <tr>
            <td>K9-DL-01</td>
            <td>Dalmation</td>
        </tr>
        <tr>
            <td>K9-PO-02</td>
            <td>Poodle</td>
        </tr>
        <tr>
            <td>K9-RT-01</td>
            <td>Golden Retriever</td>
        </tr>
        <tr>
            <td>K9-RT-02</td>
            <td>Labrador Retriever</td>
        </tr>
    </table>
</div>
<div class="clickDiv" id="alert4" >
    <h3>Reptiles</h3>
    <table border="1">
        <tr>
            <td>Product ID</td>
            <td>Name</td>
        </tr>
        <tr>
            <td>RP-LI-02</td>
            <td>Iguana</td>
        </tr>
        <tr>
            <td>RP-SN-01</td>
            <td>Rattlesnake</td>
        </tr>
    </table>
</div>
<div class="clickDiv" id="alert5" >
    <h3>Cat</h3>
    <table border="1">
        <tr>
            <td>Product ID</td>
            <td>Name</td>
        </tr>
        <tr>
            <td>FL-DLH-02</td>
            <td>Persian</td>
        </tr>
        <tr>
            <td>FL-DSH-01</td>
            <td>Manx</td>
        </tr>
    </table>
</div>
<div class="clickDiv" id="alert6" >
    <h3>Bird</h3>
    <table border="1">
        <tr>
            <td>Product ID</td>
            <td>Name</td>
        </tr>
        <tr>
            <td>AV-CB-01</td>
            <td>AmazonParrot</td>
        </tr>
        <tr>
            <td>AV-SB-02</td>
            <td>Finch</td>
        </tr>
    </table>
</div>

<script>
    var click1 = document.getElementById("click1");
    var alert1 = document.getElementById("alert1");
    click1.onmousemove = function (e) {
        alert1.style.left = e.clientX + 20 + "px"
        alert1.style.top = e.clientY + 10 + "px"
        alert1.style.display = "block";
    }

    click1.onmouseout = function (e) {
        alert1.style.display = "none";
    }

    var click2 = document.getElementById("click2");
    var alert2 = document.getElementById("alert2");
    click2.onmousemove = function (e) {
        alert2.style.left = e.clientX + 20 + "px"
        alert2.style.top = e.clientY + 10 + "px"
        alert2.style.display = "block";
    }
    click2.onmouseout = function (e) {
        alert2.style.display = "none";
    }

    var click3 = document.getElementById("click3");
    var alert3 = document.getElementById("alert3");
    click3.onmousemove = function (e) {
        alert3.style.left = e.clientX + 20 + "px"
        alert3.style.top = e.clientY + 10 + "px"
        alert3.style.display = "block";
    }
    click3.onmouseout = function (e) {
        alert3.style.display = "none";
    }

    var click4 = document.getElementById("click4");
    var alert4 = document.getElementById("alert4");
    click4.onmousemove = function (e) {
        alert4.style.left = e.clientX + 20 + "px"
        alert4.style.top = e.clientY + 10 + "px"
        alert4.style.display = "block";
    }

    click4.onmouseout = function (e) {
        alert4.style.display = "none";
    }

    var click5 = document.getElementById("click5");
    var alert5 = document.getElementById("alert5");
    click5.onmousemove = function (e) {
        alert5.style.left = e.clientX + 20 + "px"
        alert5.style.top = e.clientY + 10 + "px"
        alert5.style.display = "block";
    }

    click5.onmouseout = function (e) {
        alert5.style.display = "none";
    }

    var click6 = document.getElementById("click6");
    var alert6 = document.getElementById("alert6");
    click6.onmousemove = function (e) {
        alert6.style.left = e.clientX + 20 + "px"
        alert6.style.top = e.clientY + 10 + "px"
        alert6.style.display = "block";
    }

    click6.onmouseout = function (e) {
        alert6.style.display = "none";
    }


</script>
<%@include file="../common/IncludeBottom.jsp"%>