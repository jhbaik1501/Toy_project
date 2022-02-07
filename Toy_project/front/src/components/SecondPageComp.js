import image from "../ToyComponents/download.jpg"

const SecondPageComp = () =>{
    return(
        <body>
                  <div class="grid_container">
                      <div class="grid_item header">식물 정보 및 환경</div>
                      <div class="grid_item aside"><img src={image} alt="My Image"/></div>
                      <div class="grid_item content">
                          <span> hello <br/></span>
                      </div>
                      <div className="grid_item footer">식물 정보 : 고추냉이</div>
                  </div>
        </body>

    )
}




export default SecondPageComp;