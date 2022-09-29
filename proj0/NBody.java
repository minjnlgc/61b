public class NBody {
    
     /** To compile this file: -encoding UTF-8 */

    public static final String backgroundpic = "images/starfield.jpg";
    
    public static double readRadius(String fileName){
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        Planet[] planets = new Planet[in.readInt()];
        in.readDouble();
        for(int i=0; i < planets.length; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }
    

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        //draw background
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, backgroundpic);

        // drawing each planet
        for (Planet p : planets){
            p.draw();
        }

        //prevent flickering in the animation
        StdDraw.enableDoubleBuffering();

        // Create animation
        for(double t = 0.0; t <= T; t+= dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < planets.length; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, backgroundpic);
            for (Planet p : planets){
                p.draw();
            }
            
            // offscreen buffer    
            StdDraw.show();
            StdDraw.pause(10);
        }

        // print out the final state of the universe when the simulation is over.
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for(int i = 0; i < planets.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel,
            planets[i].mass, planets[i].imgFileName);
        }
        
    }
}
