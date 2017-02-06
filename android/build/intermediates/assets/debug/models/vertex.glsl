attribute vec4 a_position;
attribute vec2 a_texCoord0;

uniform mat4 u_projTrans;
uniform vec2 pos;
// uniform mat4 u_matRot;

varying vec2 v_texCoords;
varying vec4 posfinale;

void main() {
    v_texCoords = a_texCoord0;
    posfinale = a_position + vec4(pos, 0, 0);
    gl_Position = u_projTrans * posfinale;
}
