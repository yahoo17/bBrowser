var http = require('http');
var url = require('url');
var butil = require('./util/filter');
var bSQL = require('./util/bBrowserMysql');

const express = require('express')
const app = express()
const port = 80

app.use(express.json()) // for parsing application/json
app.use(express.urlencoded({ extended: true })) // for parsing application/x-www-form-urlencoded

function bP(str) {
    console.log(str);
}
// bSQL.QueryUser();
// bSQL.InsertUser('username','password');
app.get('/', (req, res) => {
    res.send("please check your url, bBrowser");
})
app.get('/register', (req, res) => {
    //注册
    res.send('Please use post method!')
})

app.post('/register', function (req, res) {
    var username = req.body.username;
    var password = req.body.password;
    if (username == null || password == null) {
        failureCallback();

    }

    console.log(req.body);
    // bSQL.QueryUser();
    // 成功的回调函数
    function successCallback(result) {
        console.log("音频文件创建成功: " + result);
    }

    // 失败的回调函数
    function failureCallback(error) {
        console.log("音频文件创建失败: " + error);
    }

    bSQL.InsertUser(username, password, successCallback, failureCallback);
    res.json(req.body)

});

app.post('/login', function (req, res) {
    let username = req.body.username;
    let password = req.body.password;
    if (username == null || password == null) {
        failureCallback();
    }

    // 成功的回调函数
    function successCallback(result) {
        if (result[0].password == password) {
            console.log("登录成功: " + result);
            res.json({ok: true});
        } else {
            console.log("登录失败: 密码错误");
            res.json({ok: false});
        }
    }

    // 失败的回调函数
    function failureCallback(error) {
        console.log("登录失败: " + error);
    }

    bSQL.QueryUser(username, successCallback, failureCallback);
});

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})

// app.post('/register', function (req, res) {
//     var username = req.body.username;
//     var password = req.body.password;
//     console.log(req.body);
//     // bSQL.QueryUser();
//     // 成功的回调函数
//     function successCallback(result) {
//         console.log("音频文件创建成功: " + result);
//     }

//     // 失败的回调函数
//     function failureCallback(error) {
//         console.log("音频文件创建失败: " + error);
//     }

//     bSQL.InsertUser(username, password, successCallback, failureCallback);
//     res.json(req.body)


// });

// http.createServer(function (req, res) {
//     // 解析 url 参数
//     var params = url.parse(req.url, true).query;
//     var username = butil.filerXSS(params.username);
//     var password = butil.filerXSS(params.password);

//     bP(username);
//     bP(password);
//     bSQL.QueryUser();
//     bSQL.InsertUser(username, password);

//     res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' });
//     res.write("用户名：" + params.username);
//     res.write("\n");
//     res.write("密码：" + params.password);
//     res.end();
// }).listen(80);