import React, { useState, useEffect } from 'react';
import axios from 'axios'
import './App.css';

function App() {
  // 요청받은 정보를 담아줄 변수 선언
  const [ testStr, setTestStr ] = useState('');

  // 변수 초기화
  function callback(str) {
    setTestStr(str);
  }

  // 첫 번째 렌더링을 마친 후 실행
  useEffect(
      () => {
        axios.get('/api/home2')  // http://localhost:5000 안 써줘도 괜찮다.
          .then(res=> {
          callback(res.data);
          console.log(res.data)})
          .catch()
      }, []
  );


  return (
      <div className="App">
          <header className="App-header">
              {testStr}
              <a href = ""><div class="grid-item aside">식물 정보 및 환경 보기</div></a>
          </header>
      </div>
  );
}

export default App;