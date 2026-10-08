import './index.css';

const user = {
  name: 'MCqueen',
  imageUrl: 'https://cdn11.bigcommerce.com/s-5ylnei6or5/images/stencil/1280x1280/products/1572/2565/2424_LightningMcQueen_C3_34__17709.1612894935.jpg?c=2',
  imageSize: 500,
};

let App = function () {
  return (
    <>
      <h1>{user.name}</h1>

      <img
        className="avatar"
        src={user.imageUrl}
        alt={'Photo of ' + user.name}
        style={{
          width: user.imageSize,
          height: user.imageSize
        }}
      />
    </>
  );
};

export default App;