import React, {Component} from 'react';
import info from "./info.css";
import image from "./download.jpg"

// class Info extends Component{
//     render(){
//         return(
            // <body>
            //     <div className={info.grid_container}>
            //         <div className={info.grid_item,info.header}>식물 정보 및 환경</div>
            //         <div className={info.grid_item,info.aside}><img src={image} alt="My Image"/></div>
            //         <div className={info.grid_item,info.content}>
            //             <span>조도 : 56% <br/></span> 
            //             <span>온도 : 23도<br/></span> 
            //             <span>습도 : 42%</span>
            //         </div>
            //         <div className={info.grid_item,info.footer}>식물 정보 : 고추냉이</div>
            //     </div>
            // </body>
//         )
//     }
// }

class Info extends Component{
    render(){
        return(
            <a  href="info.html"
                onClick={function(e){
                e.preventDefault();
                this.props.onChangePage();
              }.bind(this)}>식물 정보 및 환경</a>
        );
    }
}

export default Info;