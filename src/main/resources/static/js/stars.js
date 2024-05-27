import * as THREE from "../js/three.module.js";
//1.创建一个3d场景
// 1.3 渲染器Renderer
//一、 场景Scene 创建3D场景对象Scene
const scene = new THREE.Scene();
//1.1 创建一个几何体
const boxGeometry = new THREE.BoxGeometry(110,110,100);
//1.2 设置物体材质
const meshBasicMaterial = new THREE.MeshBasicMaterial({color:0xffffff});
const meshBasicMaterial2 = new THREE.MeshBasicMaterial({color:0XD9D919});
const list = [meshBasicMaterial,meshBasicMaterial2];
//1.3 网模型
const mesh1 = new THREE.Mesh(boxGeometry,meshBasicMaterial);
const mesh2 = new THREE.Mesh(boxGeometry,meshBasicMaterial2);
//1.4 物理位置
mesh1.position.set(0,0,0);
mesh2.position.set(0,100,100);
//1.5 创建光源
// const ambientLight = new THREE.AmbientLight(0x404040);
//1.5 把物理模型添加到场景中
// scene.add(ambientLight);
scene.add(mesh1);
scene.add(mesh2);
// 二、 相机Camera(要把物体渲染到html需要用到相机)
// 2.1 定义画布大小 尺寸px
const width = 400;
const height = 400;
//
const perspectiveCamera = new THREE.PerspectiveCamera(100,width/height,0.1,1000);//正投影相机
// 2.2 相机的位置
perspectiveCamera.position.set(200,300,300);
// 2.3 相机的观察目标
//perspectiveCamera.lookAt(0,0,0); //传坐标
perspectiveCamera.lookAt(mesh2.position);


// 三、渲染
//3.1 创建渲染器
const webGLRenderer = new THREE.WebGLRenderer();
//3.2 设置渲染尺寸
webGLRenderer.setSize(width,height);
webGLRenderer.setClearColor(0x228b22, 1);

//3.3 生成画面
//webGLRenderer.render(scene,perspectiveCamera);
//3.4 获取画面,渲染到html
document.getElementById("star").appendChild(webGLRenderer.domElement);

//旋转物体
function animate() {
    requestAnimationFrame( animate );
    mesh1.rotation.x += 0.01;
    mesh1.rotation.y += 0.01;

    webGLRenderer.render( scene, perspectiveCamera );
}
animate();