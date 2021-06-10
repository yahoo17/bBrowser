var mysql = require('mysql');
// var connection = mysql.createConnection({

//   host: '9.135.222.3',
//   user: 'root',
//   port: '3306',
//   password: 'EaKfc@8956KZ',
//   database: 'bBrowser',
//   useConnectionPooling: true
// });

// var connection = mysql.createConnection({
//   host: 'sh-cynosdbmysql-grp-k6exixzk.sql.tencentcdb.com',
//   user: 'root',
//   port: '20769',
//   password: 'mk5588MKU',
//   database: 'bBrowser',
//   useConnectionPooling: true
// });

var connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '123456',
  database: 'bbrowser'
});
// docker run -itd --name mysql-test -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql


function ModifyUser() {
  //查
  var modSql = 'UPDATE user SET name = ?,url = ? WHERE Id = ?';
  var modSqlParams = ['菜鸟移动站', 'https://m.runoob.com', 6];
}

function InsertUser(username, password, successCallback, failureCallback) {

  var result = 99;
  connection.connect();
  var addSql = 'INSERT INTO User(username,password) VALUES(?,?)';
  var addSqlParams = [];
  addSqlParams.push(username);
  addSqlParams.push(password);
  connection.query(addSql, addSqlParams, function (err, result) {
    if (err) {
      console.log('[INSERT ERROR] - ', err.message);
      return;
    }

    console.log('--------------------------INSERT----------------------------');
    //console.log('INSERT ID:',result.insertId);        
    console.log('INSERT ID:', result);
    console.log('-----------------------------------------------------------------\n\n');
    // connection.end();
  });
  if (result > 0) {
    successCallback(result);
  } else {
    failureCallback(result);
  }
}


// InsertUser('bee', '6666');

function QueryUser(username, successCallback, failureCallback) {
  connection.connect();

  var sql = 'SELECT password FROM User WHERE username = ?';

  var sqlParams = [];
  sqlParams.push(username);

  var result;

  connection.query(sql, sqlParams, function (err, result) {
    if (err) {
      console.log('[SELECT ERROR] - ', err.message);
      failureCallback(err);
      return;
    }

    console.log('--------------------------SELECT----------------------------');
    console.log(result);
    console.log('------------------------------------------------------------\n\n');

    successCallback(result);
  });
}

function handleDisconnect(connection) {
  connection.on('error', function (err) {
    if (!err.fatal) {
      return;
    }

    if (err.code !== 'PROTOCOL_CONNECTION_LOST') {
      throw err;
    }

    console.log('Re-connecting lost connection: ' + err.stack);

    connection = mysql.createConnection(connection.config);
    handleDisconnect(connection);
    connection.connect();
  });
}

handleDisconnect(connection);

exports.InsertUser = InsertUser;
exports.QueryUser = QueryUser;
// connection.query('SELECT 1 + 1 AS solution', function (error, results, fields) {
//   if (error) throw error;
//   console.log('The solution is: ', results[0].solution);
// });