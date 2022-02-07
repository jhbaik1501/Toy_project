import React, {Component} from 'react';
import './App.css'
import './App2.css'
import axios from 'axios'
import Info from './ToyComponents/info'
import info from "./ToyComponents/info.css";
import image from "./ToyComponents/download.jpg"



class App2 extends Component{
  constructor(props){
    super(props);
    this.state = {
      mode: 'welcome',
      data : 'Nothing'
    }
  }

  getContent(){
    var result = null;

    if(this.state.mode === 'welcome'){
      console.log("Tlqkf")
    result = 
      <body>
      <div class="grid-container">
        
        <div class="grid-item header">식물 키우기 프로젝트{this.props.data}</div>
        <div class="grid-item aside">
          <Info
            onChangePage={function(){
               axios.get('/api/home2')  // http://localhost:5000 안 써줘도 괜찮다.
                        .then(res=> {
                        this.setState({
                        data : res.data});
                        console.log(res.data)})
                        .catch()
               this.setState({
                mode:'plantInfoEnvironment'
              })
            }.bind(this)}>
          </Info>
        </div>
        <div class="grid-item content">식물 등록하기</div>
        <div class="grid-item footer">환경 조정하기</div>
      </div>
      </body>
    }

    else if(this.state.mode === "plantInfoEnvironment"){
      console.log("hello");
      result =
      <body>
          <div class="grid_container">
              <div class="grid_item header">식물 정보 및 환경</div>
              <div class="grid_item aside"><img src={image} alt="My Image"/></div>
              <div class="grid_item content">
                  <span> {this.state.data} <br/></span>
                  <span> <button onClick={() => {this.setState({mode :'welcome'}); console.log(this.state.mode)}}>뒤로가기</button> </span>
              </div>
              <div className="grid_item footer">식물 정보 : 고추냉이</div>
          </div>
      </body>
    }

    return result;
  }

  render(){
    
    return(
      this.getContent()
    );
  }
}


export default App2;